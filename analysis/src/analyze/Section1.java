package analyze;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

		HashMap<PatternEscapedPair, TreeSet<Integer>> patternProjectMM = new HashMap<PatternEscapedPair, TreeSet<Integer>>();
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
		TreeSet<String> errorPatternSet = new TreeSet<String>();
		TreeSet<String> alienPatternSet = new TreeSet<String>();
		TreeSet<String> unicodePatternSet = new TreeSet<String>();
		TreeSet<String> corpusPatternSet = new TreeSet<String>();
		while (rs.next()) {
			String pattern = rs.getString("pattern");
			int projectID = rs.getInt("uniqueSourceID");
			try {
				PatternEscapedPair patternEscapedPair = new PatternEscapedPair(pattern);
				if(patternEscapedPair.getPattern().equals("")){
					System.out.println("found empty: " + pattern);
				}else{
					TreeSet<Integer> projectIDs = patternProjectMM.get(patternEscapedPair);
					if (projectIDs == null) {
						projectIDs = new TreeSet<Integer>();
					}
					projectIDs.add(projectID);
					patternProjectMM.put(patternEscapedPair, projectIDs);
				}
			} catch (QuoteRuleException e) {
				//System.out.println("problem unquoting pattern: " + pattern);
				errorPatternSet.add(pattern); 
			}
		}
		allPatterns[0] = patternProjectMM.size();

		rs.close();
		stmt.close();
		c.close();
		
		//sort so that we always get the same order (sets do not guarantee an ordering)
		LinkedList<SortableEntry> entryList = new LinkedList<SortableEntry>();
		for(Entry<PatternEscapedPair, TreeSet<Integer>> entry : patternProjectMM.entrySet()){
			entryList.add(new SortableEntry(entry.getKey(),entry.getValue()));
		}
		Collections.sort(entryList);
		for (SortableEntry entry : entryList) {
			String pattern = entry.getKey().getPattern();
			try {
				WeightRankedRegex r = new WeightRankedRegex(pattern, entry.getValue().size());
				corpusPatternSet.add(pattern);
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
						unicodePatternSet.add(pattern);
					} else {
						alienPatternSet.add(pattern);
					}
				}
				//System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("initializeCorpus: Cannot parse " + pattern +
					" because: " + e.toString());
				errorPatternSet.add(pattern);
				// e.printStackTrace();
			} catch (QuoteRuleException e) {
				errorPatternSet.add(pattern);
			} catch (PythonParsingException e) {
				errorPatternSet.add(pattern);
			}
		}
		File errorFile = new File(PaperWriter.homePath + "analysis/pattern_tracking/errorPatterns.txt");
		File alienFile = new File(PaperWriter.homePath + "analysis/pattern_tracking/alienPatterns.txt");
		File unicodeFile = new File(PaperWriter.homePath + "analysis/pattern_tracking/unicodePatterns.txt");
		File corpusFile = new File(PaperWriter.homePath + "analysis/pattern_tracking/corpusPatterns.txt");
		errorFile.delete();
		alienFile.delete();
		unicodeFile.delete();
		corpusFile.delete();
		IOUtil.createAndWrite(new File(PaperWriter.homePath + "analysis/pattern_tracking/errorPatterns.txt"), contentFromStringSet(errorPatternSet));
		IOUtil.createAndWrite(new File(PaperWriter.homePath + "analysis/pattern_tracking/alienPatterns.txt"), contentFromStringSet(alienPatternSet));
		IOUtil.createAndWrite(new File(PaperWriter.homePath + "analysis/pattern_tracking/unicodePatterns.txt"), contentFromStringSet(unicodePatternSet));
		IOUtil.createAndWrite(new File(PaperWriter.homePath + "analysis/pattern_tracking/corpusPatterns.txt"), contentFromStringSet(corpusPatternSet));
		errorPatterns[0] = errorPatternSet.size();
		alienPatterns[0] = alienPatternSet.size();
		unicodePatterns[0] = unicodePatternSet.size();
	}
	
	private static String contentFromStringSet(Collection<String> stringSet){
		StringBuilder sb = new StringBuilder();
		for(String s : stringSet){
			sb.append(s + "\n");
		}
		return sb.toString();
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
