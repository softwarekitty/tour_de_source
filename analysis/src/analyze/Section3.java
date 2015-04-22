package analyze;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

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
	
	static void syntacticClustering(String outputPath,ArrayList<WeightRankedRegex> corpus) throws IOException, InterruptedException{
		int i=0;
		HalfMatrix halfMatrix = StringSimilarity.getJaroWinklerSimilarityMatrix(corpus);
		ArrayList<TreeSet<WeightRankedRegex>> clusters = IOUtil.getClusters(outputPath, "cosineSimilarityGraph.abc", halfMatrix.getABC(0.68), corpus);
		for(TreeSet<WeightRankedRegex> cluster : clusters){
			Iterator<WeightRankedRegex> it = cluster.iterator();
			while(it.hasNext()){
				WeightRankedRegex wrr = it.next();
				System.out.println("from cluster "+i+": "+wrr.getContent() + " weight: "+wrr.getRankableValue());
			}
			i++;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO - couldn't we do this same similarity matrix using feature
		// vectors - why not?
		ArrayList<WeightRankedRegex> corpus = new ArrayList<WeightRankedRegex>();
		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzq]\\1'", 24));
		corpus.add(new WeightRankedRegex("'\\d{3}[-. ]\\d{3}[-. ]\\d{4}'", 80));
		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 100));
		corpus.add(new WeightRankedRegex("'\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 20));
		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d'", 14));
		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzy]\\1'", 4));
		corpus.add(new WeightRankedRegex("'ab*c(embper)[^zgi]\\1'", 12));

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
		syntacticClustering(outputPath,corpus);
	}
}
