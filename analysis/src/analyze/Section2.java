package analyze;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
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

		return "";
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
		double totalWeight = 0;
		int[] featureWeight = new int[nFeatures];

		for (WeightRankedRegex wrr : corpus) {
			int[] featureCount = wrr.getFeatures().getFeatureCountArray();
			for (int i = 0; i < nFeatures; i++) {
				int count = featureCount[i];
				if (count > 0) {
					featureWeight[i] += wrr.getRankableValue();

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
			totalWeight += wrr.getRankableValue();
		}
		DecimalFormat df = new DecimalFormat("00.0");

		int totalTokens = 0;
		for (int tokens : tokensCounter) {
			totalTokens += tokens;
		}
		int adjustedTokens = totalTokens - literalTokens;
		databaseFileContent.put(C.P_LITERAL_TOKENS, Composer.percentify(literalTokens, totalTokens));
		databaseFileContent.put(C.P_LITERAL_PRESENT, Composer.percentify(literalPresent, nPatterns));

		StringBuilder sb = new StringBuilder();
		String between = " & ";
		sb.append("\\begin{center}\n\\begin{tabular}{lcccccccccc}\n\\toprule\n");
		sb.append("code & description & example & brics & hampi & Rex & RE2 & \\% tokens & Max & weight & weight\\% \\\\ \n");
		TreeSet<FeatureDetail> sortedFeatures = new TreeSet<FeatureDetail>();
		for (int i = 0; i < nFeatures; i++) {
			if (i == FeatureDictionary.I_META_LITERAL || presentCounter[i] == 0) {
				continue;
			}
			sortedFeatures.add(new FeatureDetail(i, tokensCounter[i], presentCounter[i], featureWeight[i], max[i]));
		}

		for (FeatureDetail featureDetail : sortedFeatures) {
			int ID = featureDetail.getID();
			String featureCode = fd.getCode(ID);
			String description = fd.getDescription(ID);
			String verbatimBlock = fd.getVerbatim(ID);

			String percentPresent = Composer.percentify(presentCounter[ID], nPatterns);
			String percentTokens = Composer.percentify(tokensCounter[ID], adjustedTokens);
			String maxOccurances = Composer.commafy(max[ID]);
			String weightInt = Composer.commafy(featureDetail.getRankableValue());
			String weightPercent = df.format(100 * (featureDetail.getRankableValue() / totalWeight));

			sb.append(featureCode);
			sb.append(between);
			sb.append(description);
			sb.append(between);
			sb.append(verbatimBlock);
			sb.append(between);
			sb.append(projectFeatureInclusion(ID, 0));
			sb.append(between);
			sb.append(projectFeatureInclusion(ID, 1));
			sb.append(between);
			sb.append(projectFeatureInclusion(ID, 2));
			sb.append(between);
			sb.append(projectFeatureInclusion(ID, 3));
			sb.append(between);
			// sb.append(percentPresent);
			// sb.append(between);
			sb.append(percentTokens);
			sb.append(between);
			sb.append(maxOccurances);
			sb.append(between);
			sb.append(weightInt);
			sb.append(between);
			sb.append(weightPercent);
			sb.append(" \\\\ \n\\midrule\n");
		}
		sb.append("\\bottomrule\n\\end{tabular}\n\\end{center}\n");
		return sb.toString();
	}

	private static String projectFeatureInclusion(int ID, int projectIndex) {
		// from:
		// http://www.brics.dk/automaton/doc/index.html?dk/brics/automaton/RegExp.html
		int[] bricsMissingFeatures = { FeatureDictionary.I_REP_LAZY,
				FeatureDictionary.I_CC_DECIMAL,
				FeatureDictionary.I_CC_NDECIMAL,
				FeatureDictionary.I_CC_WHITESPACE,
				FeatureDictionary.I_CC_NWHITESPACE,
				FeatureDictionary.I_CC_WORD, FeatureDictionary.I_CC_NWORD,
				FeatureDictionary.I_LOOK_AHEAD,
				FeatureDictionary.I_LOOK_AHEAD_NEGATIVE,
				FeatureDictionary.I_LOOK_BEHIND,
				FeatureDictionary.I_LOOK_BEHIND_NEGATIVE,
				FeatureDictionary.I_LOOK_NON_CAPTURE,
				FeatureDictionary.I_META_NUMBERED_BACKREFERENCE,
				FeatureDictionary.I_POS_END_ANCHOR,
				FeatureDictionary.I_POS_NONWORD,
				FeatureDictionary.I_POS_START_ANCHOR,
				FeatureDictionary.I_POS_WORD,
				FeatureDictionary.I_XTRA_END_SUBJECTLINE,
				FeatureDictionary.I_XTRA_NAMED_BACKREFERENCE,
				FeatureDictionary.I_XTRA_NAMED_GROUP_PYTHON,
				FeatureDictionary.I_XTRA_OPTIONS,
				FeatureDictionary.I_XTRA_VERTICAL_WHITESPACE };

		// by inspecting lib/regex-hampi/sampleRegex
		int[] hampiMissingFeatures = { FeatureDictionary.I_LOOK_AHEAD,
				FeatureDictionary.I_LOOK_AHEAD_NEGATIVE,
				FeatureDictionary.I_LOOK_BEHIND,
				FeatureDictionary.I_LOOK_BEHIND_NEGATIVE,
				FeatureDictionary.I_META_NUMBERED_BACKREFERENCE,
				FeatureDictionary.I_POS_NONWORD, FeatureDictionary.I_POS_WORD,
				FeatureDictionary.I_XTRA_END_SUBJECTLINE,
				FeatureDictionary.I_XTRA_VERTICAL_WHITESPACE };

		// by using Rex, these are from PaperWriter
		int[] rexMissingFeatures = { FeatureDictionary.I_REP_LAZY,
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

		// from: https://re2.googlecode.com/hg/doc/syntax.html
		int[] re2MissingFeatures = { FeatureDictionary.I_LOOK_AHEAD,
				FeatureDictionary.I_LOOK_AHEAD_NEGATIVE,
				FeatureDictionary.I_LOOK_BEHIND,
				FeatureDictionary.I_LOOK_BEHIND_NEGATIVE,
				FeatureDictionary.I_META_NUMBERED_BACKREFERENCE,
				FeatureDictionary.I_XTRA_NAMED_BACKREFERENCE, };
		int[][] excluded = { bricsMissingFeatures, hampiMissingFeatures,
				rexMissingFeatures, re2MissingFeatures };

		int[] bricsSortaFeatures = { FeatureDictionary.I_META_CAPTURING_GROUP };
		int[] hampiSortaFeatures = { FeatureDictionary.I_XTRA_OPTIONS,
				FeatureDictionary.I_META_CAPTURING_GROUP,
				FeatureDictionary.I_REP_LAZY };
		int[] rexSortaFeatures = { FeatureDictionary.I_META_CAPTURING_GROUP };
		int[] re2SortaFeatures = { FeatureDictionary.I_META_CAPTURING_GROUP };
		int[][] maybes = { bricsSortaFeatures, hampiSortaFeatures,
				rexSortaFeatures, re2SortaFeatures };

		int[] excl = excluded[projectIndex];
		for (int i : excl) {
			System.out.println("ID: "+ID+" i: "+i);
			if (i == ID) {
				return "\\no";
			}
		}
		
		int[] mby = excluded[projectIndex];
		for (int j : mby) {
			if (j == ID) {
				return "\\sorta";
			}
		}
		return "\\yes";
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
		sb.append("pair & example from corpus & nTimes \\\\ \n");
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
