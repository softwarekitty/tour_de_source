package analyze;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

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

	public static String featureStats(List<WeightRankedRegex> corpus,
			HashMap<String, String> databaseFileContent) {
		FeatureDictionary fd = new FeatureDictionary();
		int nFeatures = fd.getSize();
		int nPatterns = corpus.size();
		int literalTokens = 0;
		int literalPresent = 0;
		int[] presentCounter = new int[nFeatures];
		int[] tokensCounter = new int[nFeatures];
		int[] max = new int[nFeatures];

		for (WeightRankedRegex wrr : corpus) {
			int[] featureCount = wrr.getFeatures().getFeatureCountArray();
			for (int i = 0; i < nFeatures; i++) {
				int count = featureCount[i];
				if (count > 0) {

					if (max[i] < count) {
						max[i] = count;
						if (i != FeatureDictionary.I_META_LITERAL &&
							count > 100) {
							System.out.println("100? INSPECT THIS (" +
								fd.getCode(i) + "): " + wrr.getContent());
							IOUtil.waitNsecsOrContinue(20);
						}
					}
					tokensCounter[i] += count;
					presentCounter[i]++;
					if (i == FeatureDictionary.I_META_LITERAL) {
						literalTokens += count;
						literalPresent++;
					}
				}
			}
		}
		int totalTokens = 0;
		for (int tokens : tokensCounter) {
			totalTokens += tokens;
		}
		int adjustedTokens = totalTokens - literalTokens;
		databaseFileContent.put(C.P_LITERAL_TOKENS, Composer.percentify(literalTokens, totalTokens));
		databaseFileContent.put(C.P_LITERAL_PRESENT, Composer.percentify(literalPresent, nPatterns));

		StringBuilder sb = new StringBuilder();
		String between = " & ";
		sb.append("\\begin{center}\n\\begin{tabular}{lcccc}\n\\toprule\n");
		sb.append("feature & \\% present & \\% tokens & Avg & Max \\\\ \n");

		for (int i = 0; i < nFeatures; i++) {
			if (i == FeatureDictionary.I_META_LITERAL || presentCounter[i] == 0) {
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
			sb.append(Composer.commafy(Composer.intify("" +
				Composer.round((0.0 + tokensCounter[i]) / presentCounter[i], 0))));
			sb.append(between);
			sb.append(Composer.commafy(max[i]));
			sb.append(" \\\\ \n\\midrule\n");
		}
		sb.append("\\bottomrule\n\\end{tabular}\n\\end{center}\n");
		return sb.toString();
	}

	public static String coAppearances(List<WeightRankedRegex> corpus,
			HashMap<String, String> databaseFileContent, int tableSize) {
		FeatureDictionary fd = new FeatureDictionary();
		int nFeatures = fd.getSize();
		int[][] coAppearanceMatrix = new int[nFeatures][nFeatures];
		String[][] coAppearanceExampleMatrix = new String[nFeatures][nFeatures];
		for (int i = 0; i < nFeatures; i++) {
			for (int j = 0; j < nFeatures; j++) {
				// assume that for every highly-ranked coAppearance, a small
				// example exists
				coAppearanceExampleMatrix[i][j] = Composer.createString('X', 10);
			}
		}

		for (WeightRankedRegex wrr : corpus) {
			int[] featureCount = wrr.getFeatures().getFeatureCountArray();
			for (int i = 0; i < nFeatures; i++) {
				int count = featureCount[i];
				if (count > 0) {
					// consider the correlationMatrix
					for (int j = i; j < nFeatures; j++) {
						if (i != j && featureCount[j] > 0) {
							coAppearanceMatrix[i][j]++;
							String examplePattern = wrr.getContent();
							if (examplePattern.length() < coAppearanceExampleMatrix[i][j].length()) {
								coAppearanceExampleMatrix[i][j] = examplePattern;
							}
						}
					}
				}
			}
		}

		// finished summing appearances - add to set
		TreeSet<CoAppearance> coAppearances = new TreeSet<CoAppearance>();
		for (int i = 0; i < nFeatures; i++) {
			if (i == FeatureDictionary.I_META_LITERAL) {
				continue;
			}
			for (int j = 0; j < nFeatures; j++) {
				if (j == FeatureDictionary.I_META_LITERAL) {
					continue;
				}
				int nAppearances = coAppearanceMatrix[i][j];
				if (nAppearances > 0) {
					coAppearances.add(new CoAppearance(nAppearances, fd.getCode(i) +
						"::" + fd.getCode(j), coAppearanceExampleMatrix[i][j]));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Iterator<CoAppearance> it = coAppearances.iterator();
		String beforePattern = " & \\begin{minipage}{2in}\n\\begin{verbatim}\n";
		String betweenPatternAndWeight = "\\end{verbatim}\n\\end{minipage}\n& ";
		String afterWeight = " \\\\ \n";
		
		sb.append("\\begin{center}\n\\begin{tabular}{lcc}\n\\toprule\n");
		sb.append("pair & example & nTimes \\\\ \n");
		for (int i = 0; i < tableSize; i++) {
			if (it.hasNext()) {
				CoAppearance cap = it.next();
				sb.append("\\midrule\n");
				sb.append(cap.getContent());
				sb.append(beforePattern);
				sb.append(cap.getExample());
				sb.append(betweenPatternAndWeight);
				sb.append(cap.getRankableValue());
				sb.append(afterWeight);
			}
		}
		sb.append("\\bottomrule\n\\end{tabular}\n\\end{center}\n");
		return sb.toString();
	}

	// for the feature results table later
	// sb.append("feature & \\% present & \\% of tokens & top correlated feature &  \\% correlated\\\\ \n");

}
