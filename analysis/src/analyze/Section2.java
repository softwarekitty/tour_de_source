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

	public static String featureStats(List<WeightRankedRegex> corpus, HashMap<String, String> databaseFileContent) {
		FeatureDictionary fd = new FeatureDictionary();
		int nFeatures = fd.getSize();
		int nPatterns = corpus.size();
		int literalTokens = 0;
		int literalPresent = 0;
		int[] presentCounter = new int[nFeatures];
		int[] tokensCounter = new int[nFeatures];
		int[] max = new int[nFeatures];
		
		for(WeightRankedRegex wrr : corpus){
			int[] featureCount = wrr.getFeatures().getFeatureCountArray();
			for (int i = 0; i < nFeatures; i++) {
				int count = featureCount[i];
				// don't let literals dilute the count
				if(count > 0){
					if(max[i] < count){
						max[i]=count;
					}
					tokensCounter[i]+=count;
					presentCounter[i]++;
					if(i == FeatureDictionary.I_META_LITERAL){
						literalTokens += count;
						literalPresent++;
					}
				}
			}
		}
		int totalTokens = 0;
		for(int tokens : tokensCounter){
			totalTokens += tokens;
		}
		int adjustedTokens = totalTokens - literalTokens;
		databaseFileContent.put(C.P_LITERAL_TOKENS,Composer.percentify(literalTokens,totalTokens));
		databaseFileContent.put(C.P_LITERAL_PRESENT,Composer.percentify(literalPresent,nPatterns));
		
		StringBuilder sb = new StringBuilder();
		String between = " & ";
		sb.append("\\begin{center}\n\\begin{tabular}{lcccc}\n\\toprule\n");
		sb.append("feature & \\% present & \\% tokens & Avg & Max \\\\ \n");

		for (int i = 0; i < nFeatures; i++) {
			if(i == FeatureDictionary.I_META_LITERAL || presentCounter[i]==0){
				continue;
			}
			String percentPresent = Composer.percentify(presentCounter[i], nPatterns);
			String percentTokens = Composer.percentify(tokensCounter[i], adjustedTokens);
			String featureCode = fd.getCode(i);
			sb.append(featureCode);
			sb.append(between);
			sb.append(percentPresent);
			sb.append(between);
			sb.append(percentTokens);
			sb.append(between);
			sb.append(Composer.commafy(Composer.intify(""+Composer.round((0.0+tokensCounter[i])/presentCounter[i], 0))));
			sb.append(between);
			sb.append(Composer.commafy(max[i]));
			sb.append(" \\\\ \n\\midrule\n");
		}
		sb.append("\\bottomrule\n\\end{tabular}\n\\end{center}\n");
		return sb.toString();
	}
	
	
	// for the feature results table later
	//		sb.append("feature & \\% present & \\% of tokens & top correlated feature &  \\% correlated\\\\ \n");


}
