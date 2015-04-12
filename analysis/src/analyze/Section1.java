package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import metric.AlienFeatureException;

public class Section1 {

	static void contributeToMap(HashMap<String, Integer> databaseFileContent,
			String connectionString) throws ClassNotFoundException, SQLException {

		// the set of all distinct patterns (including alien and
		// PCRE-problematic ones)
		List<String> allPatterns = new ArrayList<String>(1024);

		// the list of patterns (with weights) that make up the corpus.
		List<RegexCite> corpus = new ArrayList<RegexCite>(1024);

		// the list of patterns (with weights) that PCRE has trouble parsing.
		List<String> errorPatterns = new ArrayList<String>(1024);
		
		// the list of patterns (with weights) that PCRE has trouble parsing.
		List<String> alienPatterns = new ArrayList<String>(1024);

		// this one scan of a resultset gets all four values
		initializeCorpus(connectionString, allPatterns, corpus, errorPatterns, alienPatterns);
		
		//1.V1 raw number of distinct patterns in the corpus
		int nDistinctPatterns = allPatterns.size();
		databaseFileContent.put(C.DISTINCT_PATTERN, nDistinctPatterns);
		
		// 1.V2 number of (non-alien) PCRE error causing patterns
		int nError = errorPatterns.size();
		databaseFileContent.put(C.N_PCRE_ERROR , nError);
		
		// 1.V3 number of alien features
		int nAlien = alienPatterns.size();
		databaseFileContent.put(C.HAS_ALIEN, nAlien);
		
		//1.V4 RC: raw minus the rest
		int nRC = corpus.size();
		databaseFileContent.put(C.N_RC, nRC);

	}

	static String contributeRString(
			HashMap<String, Integer> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {
		// mostly following:
		// http://stackoverflow.com/questions/5142842
		StringBuilder rScriptContent = new StringBuilder();
		rScriptContent.append("\n");


		// 1.P1 pie chart describing how many distinct patterns have been
		// filtered out
		// due to having an alien feature, or some PCRE parser error
		int nAlien = databaseFileContent.get(C.HAS_ALIEN);
		int nPCREError = databaseFileContent.get(C.N_PCRE_ERROR);
		int nRC = databaseFileContent.get(C.N_RC);
		//double nRaw = databaseFileContent.get(C.DISTINCT_PATTERN);
		int[] data = {nAlien,nPCREError,nRC};
		String[] labels = {"alien feature","pcre error","included patterns"};
		String[] colors = {"mediumblue","lightskyblue1","seagreen2"};
		rScriptContent.append(RComposer.composeBarplotFromData(data, labels, homePath, "partDistinctPatterns", 3.5, 2,"Preprocessing Distinct Patterns",colors));

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
