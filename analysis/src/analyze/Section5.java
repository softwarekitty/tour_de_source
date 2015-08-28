package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import metric.FeatureDictionary;
import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;

public class Section5 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) {

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {

		return "";
	}

	// after getting the behavioral graph in csharp,
	// output a human-readable dump of clusters found.
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException, InterruptedException,
			IllegalArgumentException, QuoteRuleException,
			PythonParsingException {

		String behavioral_analysis_path = PaperWriter.homePath +
			"analysis/behavioral_clustering/";

//		ArrayList<WeightRankedRegex> corpus = IOUtil.importCorpus(PaperWriter.homePath +
//			"analysis/analysis_output/exportedCorpusRaw.txt");
//		System.out.println("corpus size: " + corpus.size());

//		String filtered_corpus_path = PaperWriter.homePath +
//			"analysis/analysis_output/exportedCorpusRexEsc.txt";
		String filtered_corpus_path = PaperWriter.homePath +
				"csharp/filteredCorpus.txt";
		HashMap<Integer, WeightRankedRegex> lookup = IOUtil.getLookup(filtered_corpus_path);
		Set<Integer> lookupKeys = lookup.keySet();
		TreeSet<String> unescapedPatterns = new TreeSet<String>();
		TreeSet<Integer> nonDuplicateLookupKeys = new TreeSet<Integer>();
		
		for(Integer i : lookupKeys){
			WeightRankedRegex wrr = lookup.get(i);
			if(unescapedPatterns.add(wrr.getUnescapedPattern())){
				nonDuplicateLookupKeys.add(i);
			}
		}

		// HashMap<String, Integer> dummyCounter = new HashMap<String,
		// Integer>();
		// int[] dummyTracker = {0};
		// Section1.initializeCorpus(PaperWriter.connectionString, dummyTracker,
		// corpus, dummyTracker, dummyTracker, dummyTracker, dummyCounter);

		// to debug some problem...
		// String debugCorpus = PaperWriter.exportCorpus(corpus);
		// IOUtil.createAndWrite(new
		// File(behavioral_analysis_path,"debugCorpus.txt"), debugCorpus);

		String expectedName = "behavioralSimilarityGraph.abc";

		String fullInputFilePath = behavioral_analysis_path + expectedName;
		File finalGraphFile = new File(fullInputFilePath);
		if (!finalGraphFile.exists()) {
			createFileWithoutDuplicates(behavioral_analysis_path, expectedName, nonDuplicateLookupKeys);
		}
		DecimalFormat df = new DecimalFormat("0.00");
		TreeSet<Cluster> behavioralClusters = null;

		double[] iVals = { 1.8 };
		for (double i_value : iVals) {
			double pVals[] = { 0.75 };
			for (double p_value : pVals) {
				int[] kVals = { 83 };
				for (int k_value : kVals) {
					String suffix = "_i" + df.format(i_value) + "_p" +
						df.format(p_value) + "_k" + k_value + "_";
					String fullOutputFilePath = behavioral_analysis_path +
						"behavioralSimilarityClusters" + suffix + ".txt";
					String newOptions = " -tf gq(" + df.format(p_value) +
						") -tf #knn(" + k_value + ")";
					String mclInput = fullInputFilePath + " -I " +
						df.format(i_value) + newOptions + " --abc -o " +
						fullOutputFilePath;
					behavioralClusters = IOUtil.getClustersFromFile(fullInputFilePath, fullOutputFilePath, mclInput, lookup);
					IOUtil.dumpAllClusters(behavioral_analysis_path, behavioralClusters, "behavioralSimilarityClusterDump" +
						suffix + ".txt", suffix);
				}
			}
		}

		int[][] supportedFeatureGroups = {
				{ FeatureDictionary.I_META_CAPTURING_GROUP },
				{ FeatureDictionary.I_META_OR },
				{ FeatureDictionary.I_REP_ADDITIONAL,
						FeatureDictionary.I_REP_KLEENISH,
						FeatureDictionary.I_REP_QUESTIONABLE },
				{ FeatureDictionary.I_REP_DOUBLEBOUNDED,
						FeatureDictionary.I_REP_LOWERBOUNDED,
						FeatureDictionary.I_REP_SINGLEEXACTLY },
				{ FeatureDictionary.I_META_CC, FeatureDictionary.I_META_NCC,
						FeatureDictionary.I_CC_RANGE },
				{ FeatureDictionary.I_CC_WHITESPACE,
						FeatureDictionary.I_CC_NWHITESPACE,
						FeatureDictionary.I_CC_DECIMAL,
						FeatureDictionary.I_CC_NDECIMAL,
						FeatureDictionary.I_CC_WORD,
						FeatureDictionary.I_CC_NWORD },
				{ FeatureDictionary.I_CC_WHITESPACE,
						FeatureDictionary.I_CC_DECIMAL,
						FeatureDictionary.I_CC_WORD },
				{ FeatureDictionary.I_CC_NWHITESPACE,
						FeatureDictionary.I_CC_NDECIMAL,
						FeatureDictionary.I_CC_NWORD },
				{ FeatureDictionary.I_CC_WHITESPACE,
						FeatureDictionary.I_CC_NWHITESPACE },
				{ FeatureDictionary.I_CC_DECIMAL,
						FeatureDictionary.I_CC_NDECIMAL },
				{ FeatureDictionary.I_CC_WORD, FeatureDictionary.I_CC_NWORD },
				{ FeatureDictionary.I_META_DOT_ANY },
				{ FeatureDictionary.I_POS_END_ANCHOR,
						FeatureDictionary.I_POS_START_ANCHOR } };

		String featureDetailFilePrefix = "supportedFeatureDetail_";
		for (int[] group : supportedFeatureGroups) {
			int totalNPatterns = 0;
			StringBuilder supportedContentSB = new StringBuilder();
			String groupString = getGroupString(group, FeaturePile.fd);
			TreeSet<Integer> allProjectIDs = new TreeSet<Integer>();
			TreeSet<Cluster> realClustersContainingAny = new TreeSet<Cluster>();
			TreeSet<Cluster> allClustersContainingAny = new TreeSet<Cluster>();
			Cluster singleClusters = new Cluster(Integer.MAX_VALUE);
			for (Cluster cluster : behavioralClusters) {
				if (cluster.containsAnyFeatures(group)) {
					allClustersContainingAny.add(cluster);
					totalNPatterns += cluster.size();
					allProjectIDs.addAll(cluster.computeProjectIDs());
					if (cluster.size() > 1) {
						realClustersContainingAny.add(cluster);
					} else if (cluster.size() > 0) {
						singleClusters.add(cluster.first());
					} else {
						System.err.println("empty cluster found");
					}
				}
			}
			singleClusters.initialzeStats();
			String realClusterString = getRealClusterSample(realClustersContainingAny, 30, group);
			supportedContentSB.append(groupString + "\ntotalNProjectIDs: " +
				allProjectIDs.size() + "\ntotalNClusters: " +
				allClustersContainingAny.size() + "\ntotalNPatterns:" +
				totalNPatterns + "\nrealClusters:\n" + realClusterString +
				"\nnProjects with single pattern: " +
				singleClusters.getProjectIDs().size() + "\n");
			IOUtil.createAndWrite(new File(behavioral_analysis_path +
				featureDetailFilePrefix + groupString + ".txt"), supportedContentSB.toString());
		}

	}

	private static void createFileWithoutDuplicates(
			String behavioral_analysis_path, String expectedName,
			Set<Integer> nonDuplicateLookupKeys) throws IOException {
		StringBuilder sb = new StringBuilder();

		String oldName = "oldBehavioralSimilarityGraph.abc";
		File oldFile = new File(behavioral_analysis_path + oldName);
		LineIterator it = FileUtils.lineIterator(oldFile, "UTF-8");
		int lineCounter = 0;
		try {
			while (it.hasNext()) {
				String line = it.nextLine();
				if (lineCounter++ % 100 == 0) {
					System.out.println("line: " + line + " number: " +
						lineCounter);
				}
				String[] cols = line.split("\\s");
				Integer col0 = Integer.parseInt(cols[0]);
				Integer col1 = Integer.parseInt(cols[1]);
				if (nonDuplicateLookupKeys.contains(col0) &&
					nonDuplicateLookupKeys.contains(col1)) {
					sb.append(line + "\n");
				}

			}
		} finally {
			it.close();
		}
		File newFile = new File(behavioral_analysis_path + expectedName);
		IOUtil.createAndWrite(newFile, sb.toString());
	}

	public static String getRealClusterSample(
			TreeSet<Cluster> realClustersContainingAny, int limit,
			int[] featureIndices) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		Iterator<Cluster> it = realClustersContainingAny.iterator();
		while (it.hasNext() && counter < limit) {
			Cluster cluster = it.next();
			sb.append("(");
			sb.append(cluster.getShortestWithFeature(featureIndices));
			sb.append(":");
			sb.append(cluster.getProjectIDs().size());
			sb.append(")\n");
			counter++;
		}
		return sb.toString();
	}

	public static String getGroupString(int[] group, FeatureDictionary fd) {
		StringBuilder sb = new StringBuilder();
		for (int i : group) {
			sb.append(fd.getCode(i));
			sb.append("_");
		}
		return sb.toString();
	}
}
