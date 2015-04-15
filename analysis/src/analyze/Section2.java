package analyze;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import metric.FeatureCount;
import metric.FeatureDictionary;

public class Section2 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) {

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {

		return "...";
	}

	public static String featureStats(List<WeightRankedRegex> corpus) {
		FeatureDictionary fd = new FeatureDictionary();
		int nFeatures = fd.getSize();
		int nPatterns = corpus.size();
		int[] presentCounter = new int[nFeatures];
		int[] tokensCounter = new int[nFeatures];
		
		for(WeightRankedRegex wrr : corpus){
			int[] featureCount = wrr.getFeatures().getFeatureCountArray();
			for (int i = 0; i < nFeatures; i++) {
				int count = featureCount[i];
				if(count > 0){
					tokensCounter[i]+=count;
					presentCounter[i]++;
				}
			}
		}
		int totalTokens = 0;
		for(int tokens : tokensCounter){
			totalTokens += tokens;
		}
		
		StringBuilder sb = new StringBuilder();
		String between = " & ";
		sb.append("\\begin{center}\n\\begin{tablular}{llllll}\n\\toprule\n");
		sb.append("feature & \\% present & \\% tokens \\\\ \n");

		for (int i = 0; i < nFeatures; i++) {
			String percentPresent = Composer.percentify(presentCounter[i], nPatterns);
			String percentTokens = Composer.percentify(tokensCounter[i], totalTokens);
			String featureCode = fd.getCode(i);
			sb.append(featureCode);
			sb.append(between);
			sb.append(percentPresent);
			sb.append(between);
			sb.append(percentTokens);
			sb.append(" \\\\ \n\\midline\n");
		}
		sb.append("\\bottomrule\n\\end{tabluar}\n\\end{center}\n");
		return sb.toString();
	}
	
	
	// for the feature results table later
	//		sb.append("feature & \\% present & \\% of tokens & top correlated feature &  \\% correlated\\\\ \n");


}
