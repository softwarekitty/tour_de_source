package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import metric.AlienFeatureException;

public class Section1 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString, List<RegexCite> emptyCorpus) throws ClassNotFoundException, SQLException {

		// the set of all distinct patterns (including alien and
		// PCRE-problematic ones)
		List<String> allPatterns = new ArrayList<String>(1024);

		// the list of patterns (with weights) that PCRE has trouble parsing.
		List<String> errorPatterns = new ArrayList<String>(1024);
		
		// the list of patterns (with weights) that PCRE has trouble parsing.
		List<String> alienPatterns = new ArrayList<String>(1024);

		// this one scan of a resultset gets all four values
		initializeCorpus(connectionString, allPatterns, emptyCorpus, errorPatterns, alienPatterns);
		
		//1.V1 raw number of distinct patterns in the corpus
		int nDistinctPatterns = allPatterns.size();
		databaseFileContent.put(C.N_DISTINCT_PATTERNS, Composer.commafy(nDistinctPatterns));
		
		int nError = errorPatterns.size();
		String percentPCREError = Composer.percentify(nError, nDistinctPatterns);
		databaseFileContent.put(C.P_PCRE_ERROR, percentPCREError);
		
		int nAlien = alienPatterns.size();
		String percentAlien = Composer.percentify(nAlien, nDistinctPatterns);
		databaseFileContent.put(C.P_ALIEN, ""+percentAlien);
		
		int nRC = emptyCorpus.size();
		databaseFileContent.put(C.N_CORPUS,Composer.commafy(nRC));

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {
		// mostly following:
		// http://stackoverflow.com/questions/5142842
		StringBuilder rScriptContent = new StringBuilder();
		rScriptContent.append("\n");


//		// 1.P1 pie chart describing how many distinct patterns have been
//		// filtered out
//		// due to having an alien feature, or some PCRE parser error
//		int nAlien = databaseFileContent.get(C.HAS_ALIEN);
//		int nPCREError = databaseFileContent.get(C.N_PCRE_ERROR);
//		int nRC = databaseFileContent.get(C.N_RC);
//		//double nRaw = databaseFileContent.get(C.DISTINCT_PATTERN);
//		int[] data_P1_1 = {nAlien,nPCREError,nRC};
//		String[] labels_P1_1 = {"alien feature","pcre error","included patterns"};
//		String[] colors_P1_1 = {"mediumblue","lightskyblue1","seagreen2"};
//		rScriptContent.append(RComposer.composeBarplotFromData(data_P1_1, labels_P1_1, homePath, "partDistinctPatterns", 3.5, 2,"Preprocessing Distinct Patterns",colors_P1_1));

		return rScriptContent.toString();
	}

	private static void initializeCorpus(String connectionString,
			List<String> allPatterns, List<RegexCite> corpus,
			List<String> errorPatterns, List<String> alienPatterns) throws ClassNotFoundException, SQLException {
		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(connectionString);
		c.setAutoCommit(false);
		stmt = c.createStatement();

		// this proves that '\\s+' occurs in a certain number of projects:
		// select distinct uniqueSourceID from RegexCitationMerged where
		// (flags=0 or flags like 'arg%' or flags=128 or flags='re.DEBUG') and
		// pattern!='arg1' and pattern="'\\s+'"
		// I get the same number with the query below so it is probably working
		String query = "select pattern, count(distinct uniqueSourceID) as weight from RegexCitationMerged where (flags=0 or flags like 'arg%' or flags=128 or flags='re.DEBUG') and pattern!='arg1' group by pattern order by weight desc;";

		// these are all the distinct patterns with weight
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String pattern = rs.getString("pattern");
			int weight = rs.getInt("weight");
			allPatterns.add(pattern);
			try {
				RegexCite r = new RegexCite(pattern, weight);
				corpus.add(r);
			} catch (AlienFeatureException e) {
				System.out.println(e.getMessage());
				alienPatterns.add(pattern);
			} catch (Exception e) {
				System.out.println("Cannot parse " + pattern + " because: " +
					e.getMessage());
				errorPatterns.add(pattern);
			}
		}

		// wind down sql: '^(XIE)$'
		rs.close();
		stmt.close();
		c.close();		
	}
}
