package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

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
		
		//don't run this again - got what we needed
		System.exit(0);
		String behavioral_analysis_path = PaperWriter.homePath +
			"analysis/behavioral_clustering/";

		ArrayList<WeightRankedRegex> corpus = IOUtil.importCorpus(PaperWriter.homePath +
			"analysis/analysis_output/exportedCorpusRaw.txt");
		System.out.println("corpus size: "+corpus.size());
		// HashMap<String, Integer> dummyCounter = new HashMap<String,
		// Integer>();
		// int[] dummyTracker = {0};
		// Section1.initializeCorpus(PaperWriter.connectionString, dummyTracker,
		// corpus, dummyTracker, dummyTracker, dummyTracker, dummyCounter);

		// to debug some problem...
		// String debugCorpus = PaperWriter.exportCorpus(corpus);
		// IOUtil.createAndWrite(new
		// File(behavioral_analysis_path,"debugCorpus.txt"), debugCorpus);

		String fullInputFilePath = behavioral_analysis_path +
			"behavioralSimilarityGraph.abc";
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
					behavioralClusters = IOUtil.getClustersFromFile(fullInputFilePath, corpus, fullOutputFilePath, mclInput);
					IOUtil.dumpAllClusters(behavioral_analysis_path, behavioralClusters, corpus, "behavioralSimilarityClusterDump" +
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
						FeatureDictionary.I_CC_NWHITESPACE },
				{ FeatureDictionary.I_CC_DECIMAL,
						FeatureDictionary.I_CC_NDECIMAL },
				{ FeatureDictionary.I_CC_WORD, FeatureDictionary.I_CC_NWORD },
				{ FeatureDictionary.I_META_DOT_ANY },
				{ FeatureDictionary.I_POS_END_ANCHOR,
						FeatureDictionary.I_POS_START_ANCHOR } };

		String featureDetailFilePrefix = "supportedFeatureDetail_";
		for (int[] group : supportedFeatureGroups) {
			StringBuilder supportedContentSB = new StringBuilder();
			String groupString = getGroupString(group, FeaturePile.fd);
			TreeSet<Integer> allProjectIDs = new TreeSet<Integer>();
			TreeSet<Cluster> realClustersContainingAny = new TreeSet<Cluster>();
			Cluster singleClusters = new Cluster(Integer.MAX_VALUE);
			for (Cluster cluster : behavioralClusters) {
				if (cluster.containsAnyFeatures(group)) {
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
				allProjectIDs.size() + "\n\nrealClusters:\n" +
				realClusterString + "\nnProjects with single pattern: " +
				singleClusters.getProjectIDs().size() + "\n");
			IOUtil.createAndWrite(new File(behavioral_analysis_path +
				featureDetailFilePrefix + groupString + ".txt"), supportedContentSB.toString());
		}


	}

	public static String getRealClusterSample(
			TreeSet<Cluster> realClustersContainingAny, int limit, int[] featureIndices) {
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
