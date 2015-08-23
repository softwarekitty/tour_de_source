package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import analyze.exceptions.AlienFeatureException;
import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;

public class Section1 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString, List<WeightRankedRegex> emptyCorpus,
			HashMap<String, Integer> alienFeatureCount)
			throws ClassNotFoundException, SQLException,
			IllegalArgumentException, QuoteRuleException,
			PythonParsingException {

		// the set of all distinct patterns (including alien and
		// PCRE-problematic ones)
		int[] allPatterns = { 0 };
		int[] errorPatterns = { 0 };
		int[] alienPatterns = { 0 };
		int[] unicodePatterns = { 0 };

		// this one scan of a resultset gets all four values
		initializeCorpus(connectionString, allPatterns, emptyCorpus, errorPatterns, alienPatterns, unicodePatterns, alienFeatureCount);

		// 1.V1 raw number of distinct patterns in the corpus
		int nDistinctPatterns = allPatterns[0];
		databaseFileContent.put(C.N_DISTINCT_PATTERNS, Composer.commafy(nDistinctPatterns));

		int nError = errorPatterns[0];
		String percentPCREError = Composer.percentify(nError, nDistinctPatterns);
		databaseFileContent.put(C.N_PCRE_ERROR, Composer.commafy(nError));
		databaseFileContent.put(C.P_PCRE_ERROR, percentPCREError);

		int nAlien = alienPatterns[0];
		int nUnicode = unicodePatterns[0];
		String percentAlien = Composer.percentify(nAlien, nDistinctPatterns);
		databaseFileContent.put(C.N_ALIEN, Composer.commafy(nAlien));
		databaseFileContent.put(C.N_UNICODE, Composer.commafy(nUnicode));
		databaseFileContent.put(C.P_UNICODE, Composer.percentify(nUnicode, nDistinctPatterns));
		databaseFileContent.put(C.P_ALIEN, percentAlien);

		int nRC = emptyCorpus.size();
		databaseFileContent.put(C.N_CORPUS, Composer.commafy(nRC));

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {
		// mostly following:
		// http://stackoverflow.com/questions/5142842
		StringBuilder rScriptContent = new StringBuilder();
		rScriptContent.append("\n");

		// 1.P1 pie chart describing how many distinct patterns have been
		// filtered out
		// due to having an alien feature, or some PCRE parser error
		int nAlien = Composer.intify(databaseFileContent.get(C.N_ALIEN));
		int nPCREError = Composer.intify(databaseFileContent.get(C.N_PCRE_ERROR));
		int nRC = Composer.intify(databaseFileContent.get(C.N_CORPUS));
		// double nRaw = databaseFileContent.get(C.DISTINCT_PATTERN);
		int[] data_P1_1 = { nAlien, nPCREError, nRC };
		String[] labels_P1_1 = { "alien feature", "pcre error",
				"included patterns" };
		String[] colors_P1_1 = { "mediumblue", "lightskyblue1", "seagreen2" };
		rScriptContent.append(Composer.composeBarplotFromData(data_P1_1, labels_P1_1, homePath, "patternFiltering", 3.5, 2, colors_P1_1));

		return rScriptContent.toString();
	}

	public static void initializeCorpus(String connectionString,
			int[] allPatterns, List<WeightRankedRegex> corpus,
			int[] errorPatterns, int[] alienPatterns, int[] unicodePatterns,
			HashMap<String, Integer> alienFeatureCount)
			throws ClassNotFoundException, SQLException,
			IllegalArgumentException, QuoteRuleException,
			PythonParsingException {
		if (corpus == null) {
			throw new RuntimeException("the empty corpus should not be null");
		}

		HashMap<String, TreeSet<Integer>> patternProjectMM = new HashMap<String, TreeSet<Integer>>();
		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(connectionString);
		c.setAutoCommit(false);
		stmt = c.createStatement();

		// unlike the previous version, we will now do the group by in memory,
		// to be able to finally get an accurate count of projects per unquoted
		// pattern
		String query = "select pattern, uniqueSourceID from RegexCitationMerged where (flags=0 or flags like 'arg%' or flags=128 or flags='re.DEBUG') and pattern!='arg1';";

		// these are all the distinct patterns with weight
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String pattern = rs.getString("pattern");
			int projectID = rs.getInt("uniqueSourceID");
			allPatterns[0]++;
			try {
				String unquotedPattern = WeightRankedRegex.getUnquotedPythonPattern(pattern);
				TreeSet<Integer> projectIDs = patternProjectMM.get(unquotedPattern);
				if (projectIDs == null) {
					projectIDs = new TreeSet<Integer>();
				}
				projectIDs.add(projectID);
				patternProjectMM.put(unquotedPattern, projectIDs);

			} catch (QuoteRuleException e) {
				errorPatterns[0]++;
			}
		}

		rs.close();
		stmt.close();
		c.close();

		for (Entry<String, TreeSet<Integer>> entry : patternProjectMM.entrySet()) {
			String pattern = "'" + entry.getKey() + "'";
			try {
				WeightRankedRegex r = new WeightRankedRegex(pattern, entry.getValue().size());
				corpus.add(r);
			} catch (AlienFeatureException e) {
				String alienMessage = e.getMessage();
				if (alienMessage != null && !alienMessage.equals("")) {
					String token = e.getTokenName();
					Integer count = alienFeatureCount.get(token);
					int x = count == null ? 0 : count;
					alienFeatureCount.put(token, ++x);
					if ("<invalid>".equals(token) &&
						(pattern.startsWith("u") || pattern.contains("(?u"))) {
						unicodePatterns[0]++;
					} else {
						alienPatterns[0]++;
					}
				}
				System.out.println(e.getMessage());

			} catch (IllegalArgumentException e) {
				System.out.println("initializeCorpus: Cannot parse " + pattern +
					" because: " + e.toString());
				errorPatterns[0]++;
				// e.printStackTrace();
			} catch (QuoteRuleException e) {
				errorPatterns[0]++;
			} catch (PythonParsingException e) {
				errorPatterns[0]++;
			}
		}
	}

	public static Iterator<NamedStats> getCharacterStatsAndAddToDatabase(
			HashMap<String, String> databaseFileContent,
			List<WeightRankedRegex> corpus) {
		List<NamedStats> nsList = new LinkedList<NamedStats>();
		DescriptiveStatistics lengthStats = new DescriptiveStatistics();
		DescriptiveStatistics weightStats = new DescriptiveStatistics();
		DescriptiveStatistics tokenCountStats = new DescriptiveStatistics();
		DescriptiveStatistics distinctFeatureStats = new DescriptiveStatistics();
		for (WeightRankedRegex regex : corpus) {
			lengthStats.addValue(regex.getContent().length());
			weightStats.addValue(regex.getRankableValue());
			tokenCountStats.addValue(regex.getFeatures().getTokenCount());
			distinctFeatureStats.addValue(regex.getFeatures().getDistinctFeatureCount());
		}
		nsList.add(new NamedStats("pattern weight", weightStats));
		nsList.add(new NamedStats("token count", tokenCountStats));
		nsList.add(new NamedStats("distinct features", distinctFeatureStats));
		nsList.add(new NamedStats("pattern length", lengthStats));
		return nsList.iterator();
	}
}
