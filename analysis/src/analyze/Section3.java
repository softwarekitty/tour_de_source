package analyze;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;

public class Section3 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) {
	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {
		return "";
	}

//	static String getSyntaxClusteringTableContent(int nRows, String outputPath,
//			ArrayList<WeightRankedRegex> corpus, int functionSwitch, int topN,
//			double width) throws IOException, InterruptedException,
//			ClassNotFoundException, SQLException {
//
//		String graphName = C.functionames[functionSwitch] + "synSimGraph.abc";
//		double p_value = 0.75;
//		double i_value = 1.8;
//		double k_value = 83;
//		DecimalFormat df = new DecimalFormat("0.00");
//		String prefix = "i" + df.format(i_value) + "_p" + df.format(p_value) +
//			"_k" + k_value + "_";
//		String fullInputFilePath = outputPath + prefix + "input" + graphName;
//		String fullOutputFilePath = outputPath + prefix + "output" + graphName;
//		String mclInput = fullInputFilePath + " -I " + df.format(i_value) +
//			" -tf gq(" + df.format(p_value) + ") -tf #knn(" + k_value + ")" +
//			" --abc -o " + fullOutputFilePath;
//		HalfMatrix halfMatrix = syntacticClustering(corpus, functionSwitch);
//		TreeSet<Cluster> clusters = IOUtil.getClusters(fullInputFilePath, fullOutputFilePath, halfMatrix.getABC(p_value), corpus, mclInput,null);
//		return Composer.composeRankTable(nRows, clusters.iterator(), width, "top " +
//			topN + " regexes", "clusterWeight", "syntaxClusteringCaption", "table:syntax");
//	}

	public static HalfMatrix syntacticClustering(
			ArrayList<WeightRankedRegex> corpus, int functionSwitch) {

		HalfMatrix halfMatrix;
		switch (functionSwitch) {
		case C.COS:
			halfMatrix = StringSimilarity.getCosineSimilarityMatrix(corpus);
			break;
		case C.JACC:
			halfMatrix = StringSimilarity.getJaccardSimilarityMatrix(corpus);
			break;
		case C.JAROW:
			halfMatrix = StringSimilarity.getJaroWinklerSimilarityMatrix(corpus);
			break;
		case C.LCS:
			halfMatrix = StringSimilarity.getLongestCommonSubstringSimilarityMatrix(corpus);
			break;
		case C.LEV:
			halfMatrix = StringSimilarity.getLevensteinSimilarityMatrix(corpus);
			break;
		case C.SFT:
			halfMatrix = StringSimilarity.getSift3SimilarityMatrix(corpus);
			break;
		default:
			halfMatrix = StringSimilarity.getJaccardSimilarityMatrix(corpus);
		}
		return halfMatrix;
	}

	// private static void printClusters(TreeSet<Cluster> clusters){
	// int i=0;
	// for(Cluster cluster : clusters){
	// Iterator<WeightRankedRegex> it = cluster.iterator();
	// while(it.hasNext()){
	// WeightRankedRegex wrr = it.next();
	// System.out.println("from cluster "+i+": "+wrr.getContent() +
	// " weight: "+wrr.getRankableValue());
	// }
	// i++;
	// }
	// }

	// // output info about clusters
	// int[][] unsupportedFeatureGroups = {
	// { FeatureDictionary.I_REP_LAZY },
	// { FeatureDictionary.I_POS_WORD, FeatureDictionary.I_POS_NONWORD },
	// { FeatureDictionary.I_LOOK_AHEAD,
	// FeatureDictionary.I_LOOK_AHEAD_NEGATIVE,
	// FeatureDictionary.I_LOOK_NON_CAPTURE },
	// { FeatureDictionary.I_LOOK_BEHIND,
	// FeatureDictionary.I_LOOK_BEHIND_NEGATIVE },
	// { FeatureDictionary.I_META_NUMBERED_BACKREFERENCE },
	// { FeatureDictionary.I_XTRA_NAMED_BACKREFERENCE,
	// FeatureDictionary.I_XTRA_NAMED_GROUP_PYTHON },
	// { FeatureDictionary.I_XTRA_VERTICAL_WHITESPACE },
	// { FeatureDictionary.I_XTRA_OPTIONS },
	// { FeatureDictionary.I_XTRA_END_SUBJECTLINE } };
	//
	// //experimenting with different clustering ideas
	// TreeSet<Cluster> syntacticClusters =
	// Section3.syntacticClustering(behavioral_analysis_path, corpus,
	// functionSwitch, minSimilarity);
	// featureDetailFilePrefix = "unsupportedFeatureDetail_";
	// for (int[] group : unsupportedFeatureGroups) {
	// StringBuilder unsupportedContentSB = new StringBuilder();
	// String groupString = getGroupString(group, FeaturePile.fd);
	// TreeSet<Integer> allProjectIDs = new TreeSet<Integer>();
	// TreeSet<Cluster> realClustersContainingAny = new TreeSet<Cluster>();
	// Cluster singleClusters = new Cluster(Integer.MAX_VALUE);
	//
	//
	//
	//
	//
	//
	// singleClusters.initialzeStats();
	// String realClusterString =
	// getRealClusterSample(realClustersContainingAny, 30, group);
	// unsupportedContentSB.append(groupString + "\ntotalNProjectIDs: " +
	// allProjectIDs.size() + "\n\nrealClusters:\n" +
	// realClusterString + "\nnProjects with single pattern: " +
	// singleClusters.getProjectIDs().size() + "\n");
	// IOUtil.createAndWrite(new File(behavioral_analysis_path +
	// featureDetailFilePrefix + groupString + ".txt"),
	// unsupportedContentSB.toString());
	// }

	public static void main(String[] args) throws IOException,
			InterruptedException, IllegalArgumentException, QuoteRuleException,
			PythonParsingException, ClassNotFoundException, SQLException {


		
		// TODO - couldn't we do this same similarity matrix using feature
		String[] names = { "cos", "jacc", "jaroW", "lev", "lcs", "sift" };
		// vectors - why not?
		ArrayList<WeightRankedRegex> corpus = IOUtil.getRandomSubsetOf(IOUtil.importCorpus(PaperWriter.homePath +
				 "analysis/analysis_output/exportedCorpusRaw.txt"), 0.1);
//		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzq]\\1'", 24));
//		corpus.add(new WeightRankedRegex("'\\d{3}[-. ]\\d{3}[-. ]\\d{4}'", 80));
//		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 100));
//		corpus.add(new WeightRankedRegex("'\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 20));
//		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d'", 14));
//		corpus.add(new WeightRankedRegex("'elephants'", 21));
//		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzy]\\1'", 4));
//		corpus.add(new WeightRankedRegex("'b*c(embper)[^zgi]\\1'", 12));
//		corpus.add(new WeightRankedRegex("'b*c(embper)[^zgi]\\1'", 1));
		
		HashMap<Integer, WeightRankedRegex> lookup = new HashMap<Integer,WeightRankedRegex>();
		for(int i=0;i<corpus.size();i++){
			lookup.put(i, corpus.get(i));
		}
		HalfMatrix cosineMatrix = StringSimilarity.getCosineSimilarityMatrix(corpus);
		HalfMatrix jaccardMatrix = StringSimilarity.getJaccardSimilarityMatrix(corpus);
		HalfMatrix jaroWinklerMatrix = StringSimilarity.getJaroWinklerSimilarityMatrix(corpus);
		HalfMatrix levenshteinMatrix = StringSimilarity.getLevensteinSimilarityMatrix(corpus);
		HalfMatrix longestCommonSubstringMatrix = StringSimilarity.getLongestCommonSubstringSimilarityMatrix(corpus);
		HalfMatrix sift3Matrix = StringSimilarity.getSift3SimilarityMatrix(corpus);
		HalfMatrix[] testers = new HalfMatrix[6];
		testers[0] = cosineMatrix;
		testers[1] = jaccardMatrix;
		testers[2] = jaroWinklerMatrix;
		testers[3] = levenshteinMatrix;
		testers[4] = longestCommonSubstringMatrix;
		testers[5] = sift3Matrix;

		String outputPath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/syntactic_clustering/";
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < 6; i++) {
			HalfMatrix halfMatrix = testers[i];
			double[] iVals = { 2,4};
			for (double i_value : iVals) {
				double pVals[] = { 0.18, 0.27, 0.36, 0.72, 0.80, 0.88};
				for (double p_value : pVals) {
					int[] kVals = { 100 };
					for (int k_value : kVals) {
						String graphName = C.functionames[i] +
								"synSimGraph.abc";
						String suffix = "_i" + df.format(i_value) + "_p" +
								df.format(p_value) + "_k" + k_value + "_" +
								names[i] + "_";
							String fullInputFilePath = outputPath + suffix +
								"input" + graphName;
							String fullOutputFilePath = outputPath + suffix +
								"output" + graphName;
							String mclInput = fullInputFilePath + " -I " +
								df.format(i_value) + " -tf gq(" +
								df.format(p_value) + ") -tf #knn(" + k_value + ")" +
								" --abc -o " + fullOutputFilePath;
						//jaroW or jaccard
						if((i==1 || i==2) && p_value >0.36){
							TreeSet<Cluster> syntacticClusters = IOUtil.getClusters(fullInputFilePath, fullOutputFilePath, halfMatrix.getABC(p_value), corpus, mclInput,lookup);
							IOUtil.dumpAllClusters(outputPath, syntacticClusters, corpus, "syntacticSimilarityClusterDump" +
								suffix + ".txt", suffix);
						//lcs or lev
						}else if((i==3 || i==4)&& p_value < 0.72){
							TreeSet<Cluster> syntacticClusters = IOUtil.getClusters(fullInputFilePath, fullOutputFilePath, halfMatrix.getABC(p_value), corpus, mclInput,lookup);
							IOUtil.dumpAllClusters(outputPath, syntacticClusters, corpus, "syntacticSimilarityClusterDump" +
								suffix + ".txt", suffix);
						}
					}
				}
			}
			// System.out.println(names[i]);
			// System.out.println(testers[i]);
			// System.out.println();
		}

		// ArrayList<WeightRankedRegex> corpus =
		// IOUtil.importCorpus(PaperWriter.homePath +
		// "analysis/analysis_output/exportedCorpusRaw.txt");
		//
		// String outputPath =
		// "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/syntactic_clustering/";
		// DecimalFormat df = new DecimalFormat("0.00");
//		String unescaped_corpus_path = PaperWriter.homePath +
//				"analysis/exportedCorpusAll.txt";
//		HashMap<Integer, WeightRankedRegex> lookup = IOUtil.getLookup(corpus, unescaped_corpus_path);
		// for(int i=0;i<6;i++){
		// HalfMatrix halfMatrix = syntacticClustering( corpus, i);
		// System.out.println(names[i]);
		// double[] iVals = { 1.8, 3.3, 5.0 };
		// for (double i_value : iVals) {
		// double pVals[] = { 0.75, 0.97 };
		// for (double p_value : pVals) {
		// int[] kVals = { 40, 80, 120 };
		// for (int k_value : kVals) {
		// String graphName = C.functionames[i] + "synSimGraph.abc";
		// String suffix = "_i" + df.format(i_value) + "_p" +
		// df.format(p_value) + "_k" + k_value + "_"+names[i]+"_";
		// String fullInputFilePath = outputPath + suffix+"input"+graphName;
		// String fullOutputFilePath = outputPath + suffix+"output"+graphName;
		// String mclInput = fullInputFilePath + " -I " +
		// df.format(i_value) + " -tf gq(" + df.format(p_value) +
		// ") -tf #knn(" + k_value + ")" + " --abc -o " +
		// fullOutputFilePath;
		// TreeSet<Cluster> syntacticClusters =
		// IOUtil.getClusters(fullInputFilePath,fullOutputFilePath,
		// halfMatrix.getABC(p_value), corpus, mclInput, lookup);
		// IOUtil.dumpAllClusters(outputPath, syntacticClusters, corpus,
		// "behavioralSimilarityClusterDump" +
		// suffix + ".txt", suffix);
		// }
		// }
		// }
		// System.out.println();
		// }
	}
}
