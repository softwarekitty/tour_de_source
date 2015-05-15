package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
// import org.rosuda.JRI.Rengine;
// import org.rosuda.JRI.REXP;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import metric.FeatureDictionary;

import org.apache.commons.io.FileUtils;
// c.execute('''CREATE TABLE RegexCitation (uniqueSourceID int, sourceJSON text,
// fileHash char(44), filePath text, pattern text, flags int, regexFunction
// int)''')
// c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')


import analyze.exceptions.ValueMissingException;

public class PaperWriter {
	private static ArrayList<WeightRankedRegex> corpus;
	private static HashMap<String, Integer> alienFeatureCount;

	// the delimiter character for our 'csv' files used by latex
	private static char d = '•';
	public static final String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/";
	public static final String connectionString = "jdbc:sqlite:" + homePath +
		"tools/merged/merged_report.db";

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, ValueMissingException, IOException,
			InterruptedException {
		System.out.println("begin paper writer");
		corpus = new ArrayList<WeightRankedRegex>(1024);
		alienFeatureCount = new HashMap<String, Integer>();

		// populate the map with keys for the Latex database
		HashMap<String, String> databaseFileContent = new HashMap<String, String>();

		// the SectionX methods are called here
		populateTexDatabase(databaseFileContent, connectionString);

		// Below here we are making files
		List<NameContentsPair> filesToMake = new LinkedList<NameContentsPair>();

		// An R script to make images
		filesToMake.add(new NameContentsPair(C.R_SCRIPTNAME, createImagesScript(connectionString, homePath, databaseFileContent)));

		// create the table showing source,Q1,Avg,Med,Q3,Max for
		// filesPerProject, rFilesPerProject, regexPerFile
		filesToMake.add(new NameContentsPair("saturation.tex", Composer.composeHistogramTable(4, Section0.getContextStatsAndAddToDatabase(connectionString, databaseFileContent),"How Saturated are Projects with Utilizations? (RQ1)","table:saturation")));

		// make a latex table with the top N regexes by weight.
		filesToMake.add(new NameContentsPair("topNW.tex", Composer.composeRankTable(10, corpus.iterator(), 2.4, "pattern", "nProjects", "Top 10 Patterns by nProjects (RQ1)","table:topNW")));

		// create the table showing source,Q1,Avg,Med,Q3,Max for pattern weight,
		// distinct features, token count and pattern length
		filesToMake.add(new NameContentsPair("patternStats.tex", Composer.composeHistogramTable(4, Section1.getCharacterStatsAndAddToDatabase(databaseFileContent, corpus), "Pattern Characteristics (RQ1)","table:patternStats")));

		// create the table showing source,Q1,Avg,Med,Q3,Max for pattern weight,
		// distinct features, token count and pattern length
		filesToMake.add(new NameContentsPair("exportedCorpusRaw.txt", exportCorpusRaw(corpus)));

		filesToMake.add(new NameContentsPair("exportedCorpusRex.txt", exportCorpusRex(corpus)));
		
		filesToMake.add(new NameContentsPair("exportedCorpusRexEsc.txt", exportCorpusRexEsc(corpus)));
		
		filesToMake.add(new NameContentsPair("exportedCorpusAll.txt", exportCorpusUnescaped(corpus)));



		// list of alien features excluded
		filesToMake.add(new NameContentsPair("alienFeatures.txt", stringifyAlienFeatures()));

		// stats about how features are used
		filesToMake.add(new NameContentsPair("featureStats.tex", Section2.featureStats(corpus, databaseFileContent, connectionString)));

		// a table for the top N feature coAppearances
		filesToMake.add(new NameContentsPair("coApp.tex", Section2.coAppearances(corpus, databaseFileContent, 10)));
		
		
		// ALWAYS DO THIS LAST (so that above straggler functions can add data)
		// the key value database for strings in the paper
		filesToMake.add(new NameContentsPair("database.csv", stringifyMap(databaseFileContent)));

		// a table for the top N syntax clusters, using different string
		// similarities
		// int nRows = 6;
		// double width = 2.8;
		// int nExamples = 3;
		// double minSimilarity = 0.75;
		//
		// int functionSwitch = C.LCS;
		// filesToMake.add(new
		// NameContentsPair(C.functionames[functionSwitch]+"Clusters.tex",
		// Section3.getSyntaxClusteringTableContent(nRows,homePath +
		// "analysis/analysis_output/", corpus, functionSwitch, minSimilarity,
		// nExamples, width)));
		//
		// functionSwitch = C.COS;
		// filesToMake.add(new
		// NameContentsPair(C.functionames[functionSwitch]+"Clusters.tex",
		// Section3.getSyntaxClusteringTableContent(nRows,homePath +
		// "analysis/analysis_output/", corpus, functionSwitch, minSimilarity,
		// nExamples, width)));
		//
		// functionSwitch = C.JACC;
		// filesToMake.add(new
		// NameContentsPair(C.functionames[functionSwitch]+"Clusters.tex",
		// Section3.getSyntaxClusteringTableContent(nRows,homePath +
		// "analysis/analysis_output/", corpus, functionSwitch, minSimilarity,
		// nExamples, width)));
		//
		// functionSwitch = C.JAROW;
		// filesToMake.add(new
		// NameContentsPair(C.functionames[functionSwitch]+"Clusters.tex",
		// Section3.getSyntaxClusteringTableContent(nRows,homePath +
		// "analysis/analysis_output/", corpus, functionSwitch, minSimilarity,
		// nExamples, width)));
		//
		// functionSwitch = C.LEV;
		// filesToMake.add(new
		// NameContentsPair(C.functionames[functionSwitch]+"Clusters.tex",
		// Section3.getSyntaxClusteringTableContent(nRows,homePath +
		// "analysis/analysis_output/", corpus, functionSwitch, minSimilarity,
		// nExamples, width)));
		//
		// functionSwitch = C.SFT;
		// filesToMake.add(new
		// NameContentsPair(C.functionames[functionSwitch]+"Clusters.tex",
		// Section3.getSyntaxClusteringTableContent(nRows,homePath +
		// "analysis/analysis_output/", corpus, functionSwitch, minSimilarity,
		// nExamples, width)));
		//

		// createContent
		generateArtifacts(filesToMake, homePath);
		System.out.println("finished paper writer");
	}

	private static String stringifyAlienFeatures() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> entry : alienFeatureCount.entrySet()) {
			sb.append(entry.getKey() + "::" + entry.getValue() + "\n");
		}
		return sb.toString();
	}

	// This export is for Rex, so we must filter everything Rex cannot support.
	// here is an error message about what Rex cannot support from Rex:
	// The following constructs are currently not supported: anchors \G, \b, \B,
	// named groups, lookahead, lookbehind, as-few-as-possible quantifiers,
	// backreferences,
	// conditional alternation, substitution
	public static String exportCorpusRex(
			ArrayList<WeightRankedRegex> corpusList) {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRankedRegex> it = corpusList.iterator();
		int i = 0;
		while (it.hasNext()) {
			WeightRankedRegex wrr = it.next();
			if (rexCompatible(wrr)) {
				sb.append(i + "\t" + wrr.getUnescapedPattern() + "\n");
			}
			// this 'i' is the way back to the original entry in the corpusList,
			// so it should increment for each wrr, compatible or not
			i++;
		}
		return sb.toString();
	}

	// This export is so that other steps can skip computing the corpus from
	// database
	public static String exportCorpusRaw(
			ArrayList<WeightRankedRegex> corpusList) {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRankedRegex> it = corpusList.iterator();
		int i = 0;
		while (it.hasNext()) {
			WeightRankedRegex wrr = it.next();
			sb.append(i + "\t" + wrr.getRankableValue()+"\t"+wrr.getContent() + "\n");
			i++;
		}
		return sb.toString();
	}
	

	private static String exportCorpusRexEsc(
			ArrayList<WeightRankedRegex> corpusList) {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRankedRegex> it = corpusList.iterator();
		int i = 0;
		while (it.hasNext()) {
			WeightRankedRegex wrr = it.next();
			if (rexCompatible(wrr)) {
				sb.append(i + "\t" + wrr.getContent() + "\n");
			}
			// this 'i' is the way back to the original entry in the corpusList,
			// so it should increment for each wrr, compatible or not
			i++;
		}
		return sb.toString();
	}

	
	// This export is for an unescaped version of the whole corpus
	public static String exportCorpusUnescaped(
			ArrayList<WeightRankedRegex> corpusList) {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRankedRegex> it = corpusList.iterator();
		int i = 0;
		while (it.hasNext()) {
			WeightRankedRegex wrr = it.next();
			sb.append(i + "\t" + wrr.getUnescapedPattern() + "\n");
			i++;
		}
		return sb.toString();
	}

	private static boolean rexCompatible(WeightRankedRegex wrr) {
		int[] features = wrr.getFeatures().getFeatureCountArray();
		int[] incompatibleIndices = { FeatureDictionary.I_REP_LAZY,
				FeatureDictionary.I_LOOK_AHEAD, FeatureDictionary.I_LOOK_AHEAD,
				FeatureDictionary.I_LOOK_BEHIND,
				FeatureDictionary.I_LOOK_BEHIND_NEGATIVE,
				FeatureDictionary.I_LOOK_NON_CAPTURE,
				FeatureDictionary.I_META_NUMBERED_BACKREFERENCE,
				FeatureDictionary.I_XTRA_NAMED_BACKREFERENCE,
				FeatureDictionary.I_POS_NONWORD, FeatureDictionary.I_POS_WORD,
				FeatureDictionary.I_XTRA_NAMED_GROUP_PYTHON,
				FeatureDictionary.I_XTRA_OPTIONS,
				FeatureDictionary.I_XTRA_END_SUBJECTLINE };
		for (int i : incompatibleIndices) {
			if (features[i] != 0) {
				return false;
			}
		}
		return true;
	}

	private static void generateArtifacts(List<NameContentsPair> filesToMake,
			String homePath) throws IOException, InterruptedException {

		// clean the old output, if any
		String outputPath = homePath + "analysis/analysis_output/";
		FileUtils.cleanDirectory(new File(outputPath));

		// create all files using the list of name, contents
		for (NameContentsPair ncp : filesToMake) {
			System.out.println("creating " + ncp.getFilename());
			File f = new File(outputPath + ncp.getFilename());
			IOUtil.createAndWrite(f, ncp.getContents());
		}

		// run the R script
		Process p = Runtime.getRuntime().exec("/usr/local/bin/R CMD BATCH " +
			outputPath + C.R_SCRIPTNAME);

		// add + " /dev/null" to the end to silence output
		p.waitFor();
	}

	// note this depends heavily on databaseFileContent populating
	// having fields poplated in order.
	private static String createImagesScript(String connectionString,
			String homePath, HashMap<String, String> databaseFileContent)
			throws ClassNotFoundException, SQLException {

		StringBuilder rString = new StringBuilder();
		rString.append(Section0.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section1.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section2.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section3.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section4.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section5.contributeRString(databaseFileContent, connectionString, homePath));
		return rString.toString();
	}

	private static void populateTexDatabase(
			HashMap<String, String> databaseFileContent, String connectionString)
			throws ClassNotFoundException, SQLException, ValueMissingException {
		Section0.contributeToMap(databaseFileContent, connectionString);
		Section1.contributeToMap(databaseFileContent, connectionString, corpus, alienFeatureCount);
		Section2.contributeToMap(databaseFileContent, connectionString);
		Section3.contributeToMap(databaseFileContent, connectionString);
		Section4.contributeToMap(databaseFileContent, connectionString);
		Section5.contributeToMap(databaseFileContent, connectionString);
	}

	private static String stringifyMap(HashMap<String, String> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("key" + d + "value\n");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> e : entrySet) {
			sb.append(e.getKey());
			sb.append(d);
			sb.append(e.getValue() + "\n");
		}
		return sb.toString();
	}

}
