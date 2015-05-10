package analyze;

import java.io.IOException;
import java.sql.SQLException;
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
	
	static String getSyntaxClusteringTableContent(int nRows, String outputPath,ArrayList<WeightRankedRegex> corpus, int functionSwitch, double minSimilarity, int topN, double width) throws IOException, InterruptedException, ClassNotFoundException, SQLException{
		TreeSet<Cluster> clusters = syntacticClustering(outputPath, corpus, functionSwitch, minSimilarity, topN);
		return Composer.composeRankTable(nRows,clusters.iterator(), width, "top "+ topN+ " regexes", "clusterWeight","syntaxClusteringCaption","table:syntax");
	}
	
	static TreeSet<Cluster> syntacticClustering(String outputPath,ArrayList<WeightRankedRegex> corpus, int functionSwitch, double minSimilarity, int topN) throws IOException, InterruptedException, ClassNotFoundException, SQLException{
		
		HalfMatrix halfMatrix;
		switch(functionSwitch){
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
		String graphName = C.functionames[functionSwitch] + "SimilarityGraph.abc";
		return IOUtil.getClusters(outputPath, graphName, halfMatrix.getABC(minSimilarity), corpus, topN, 2.0);
	}
	
	private static void printClusters(TreeSet<Cluster> clusters){
		int i=0;
		for(Cluster cluster : clusters){
			Iterator<WeightRankedRegex> it = cluster.iterator();
			while(it.hasNext()){
				WeightRankedRegex wrr = it.next();
				System.out.println("from cluster "+i+": "+wrr.getContent() + " weight: "+wrr.getRankableValue());
			}
			i++;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException, QuoteRuleException, PythonParsingException, ClassNotFoundException, SQLException {
		// TODO - couldn't we do this same similarity matrix using feature
		// vectors - why not?
		ArrayList<WeightRankedRegex> corpus = new ArrayList<WeightRankedRegex>();
		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzq]\\1'", 24));
		corpus.add(new WeightRankedRegex("'\\d{3}[-. ]\\d{3}[-. ]\\d{4}'", 80));
		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 100));
		corpus.add(new WeightRankedRegex("'\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 20));
		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d'", 14));
		corpus.add(new WeightRankedRegex("'elephants'", 21));
		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzy]\\1'", 4));
		corpus.add(new WeightRankedRegex("'b*c(embper)[^zgi]\\1'", 12));
		corpus.add(new WeightRankedRegex("'b*c(embper)[^zgi]\\1'", 1));

		HalfMatrix cosineMatrix = StringSimilarity.getCosineSimilarityMatrix(corpus);
		HalfMatrix jaccardMatrix = StringSimilarity.getJaccardSimilarityMatrix(corpus);
		HalfMatrix jaroWinklerMatrix = StringSimilarity.getJaroWinklerSimilarityMatrix(corpus);
		HalfMatrix levenshteinMatrix = StringSimilarity.getLevensteinSimilarityMatrix(corpus);
		HalfMatrix longestCommonSubstringMatrix = StringSimilarity.getLongestCommonSubstringSimilarityMatrix(corpus);
		HalfMatrix sift3Matrix = StringSimilarity.getSift3SimilarityMatrix(corpus);
		HalfMatrix[] testers = new HalfMatrix[6];
		String[] names = { "cos", "jacc", "jaroW", "lev", "lcs", "sift" };
		testers[0] = cosineMatrix;
		testers[1] = jaccardMatrix;
		testers[2] = jaroWinklerMatrix;
		testers[3] = levenshteinMatrix;
		testers[4] = longestCommonSubstringMatrix;
		testers[5] = sift3Matrix;
		for (int i = 0; i < 6; i++) {
			System.out.println(names[i]);
			System.out.println(testers[i]);
			System.out.println();
		}
		String outputPath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/analysis_output/";
		
		for(int i=0;i<6;i++){
			System.out.println(names[i]);
			TreeSet<Cluster> clusters = syntacticClustering(outputPath,corpus,i, 0.67, 3);	
			printClusters(clusters);
			System.out.println();
		}
	}
}
