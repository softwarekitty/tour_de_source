package analyze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class StringSimilarity {
	
	public static HalfMatrix getSift3SimilarityMatrix(
			ArrayList<WeightRankedRegex> corpus) {
		HalfMatrix matrix = new HalfMatrix(corpus.size());
		for (int i = 0; i < corpus.size(); i++) {
			String si = corpus.get(i).getUnescapedPattern();
			for (int j = 0; j < i; j++) {
				String patternJ = corpus.get(j).getUnescapedPattern();
				int maxLength = Math.max(si.length(), patternJ.length());
				double similarity = 0;
				if (maxLength > 0) {
					similarity = getDistance(si, patternJ, 4);
				}
				matrix.set(i, j, similarity);
			}
		}
		return matrix;
	}
	
	public static HalfMatrix getCosineSimilarityMatrix(
			ArrayList<WeightRankedRegex> corpus) {
		HalfMatrix matrix = new HalfMatrix(corpus.size());
		for (int i = 0; i < corpus.size(); i++) {
			String si = corpus.get(i).getUnescapedPattern();
			for (int j = 0; j < i; j++) {
				String patternJ = corpus.get(j).getUnescapedPattern();
				int maxLength = Math.max(si.length(), patternJ.length());
				double similarity = 0;
				if (maxLength > 0) {
					similarity = cosineSimilarity(si,patternJ);
				}
				matrix.set(i, j, similarity);
			}
		}
		return matrix;
	}
	
	public static HalfMatrix getJaccardSimilarityMatrix(
			ArrayList<WeightRankedRegex> corpus) {
		HalfMatrix matrix = new HalfMatrix(corpus.size());
		for (int i = 0; i < corpus.size(); i++) {
			String si = corpus.get(i).getUnescapedPattern();
			for (int j = 0; j < i; j++) {
				String patternJ = corpus.get(j).getUnescapedPattern();
				int maxLength = Math.max(si.length(), patternJ.length());
				double similarity = 0;
				if (maxLength > 0) {
					similarity = jaccardSimilarity(si, patternJ);
				}
				matrix.set(i, j, similarity);
			}
		}
		return matrix;
	}
	
	public static HalfMatrix getLevensteinSimilarityMatrix(
			ArrayList<WeightRankedRegex> corpus) {
		HalfMatrix matrix = new HalfMatrix(corpus.size());
		for (int i = 0; i < corpus.size(); i++) {
			String si = corpus.get(i).getUnescapedPattern();
			for (int j = 0; j < i; j++) {
				String patternJ = corpus.get(j).getUnescapedPattern();
				int maxLength = Math.max(si.length(), patternJ.length());
				double similarity = 0;
				if (maxLength > 0) {
					similarity = 1.0 - (StringUtils.getLevenshteinDistance(si, patternJ) / (0.0 + maxLength));
				}
				matrix.set(i, j, similarity);
			}
		}
		return matrix;
	}

	public static HalfMatrix getLongestCommonSubstringSimilarityMatrix(
			ArrayList<WeightRankedRegex> corpus) {
		HalfMatrix matrix = new HalfMatrix(corpus.size());
		for (int i = 0; i < corpus.size(); i++) {
			String si = corpus.get(i).getUnescapedPattern();
			for (int j = 0; j < i; j++) {
				String patternJ = corpus.get(j).getUnescapedPattern();
				int maxLength = Math.max(si.length(), patternJ.length());
				double similarity = 0;
				if (maxLength > 0) {
					similarity = longestSubstr(si, patternJ) /
						(0.0 + maxLength);
				}
				matrix.set(i, j, similarity);
			}
		}
		return matrix;
	}

	public static HalfMatrix getJaroWinklerSimilarityMatrix(
			ArrayList<WeightRankedRegex> corpus) {
		HalfMatrix matrix = new HalfMatrix(corpus.size());
		for (int i = 0; i < corpus.size(); i++) {
			String si = corpus.get(i).getUnescapedPattern();
			for (int j = 0; j < i; j++) {
				double similarity = StringUtils.getJaroWinklerDistance(si, corpus.get(j).getUnescapedPattern());
				matrix.set(i, j, similarity);
			}
		}
		return matrix;
	}

	// I've done this a few times in Pavan's class
	public static double jaccardSimilarity(String s1, String s2) {
		TreeSet<Character> s1Chars = getChars(s1);
		TreeSet<Character> s2Chars = getChars(s2);

		TreeSet<Character> intersection = new TreeSet<Character>();
		TreeSet<Character> union = new TreeSet<Character>();

		union.addAll(s1Chars);
		union.addAll(s2Chars);

		intersection.addAll(s2Chars);
		intersection.retainAll(s1Chars);

		return (0.0 + intersection.size()) / union.size();
	}

	// thanks to lucid article: http://www.gettingcirrius.com/2010/12/calculating-similarity-part-1-cosine.html
	public static double cosineSimilarity(String s1, String s2) {
		HashMap<Character, Integer> charIntMap = getCharIntMap(s1, s2);
		int[] v1 = new int[charIntMap.size()];
		int[] v2 = new int[charIntMap.size()];
		for (char c : s1.toCharArray()) {
			v1[charIntMap.get(c)]++;
		}
		for (char c : s2.toCharArray()) {
			v2[charIntMap.get(c)]++;
		}
		double dotProduct = 0;
		double magnitude1 = 0;
		double magnitude2 = 0;
		for (int i = 0; i < v1.length; i++) {
			dotProduct += v1[i] * v2[i];
			magnitude1 += Math.pow(v1[i], 2);
			magnitude2 += Math.pow(v2[i], 2);
		}
		return dotProduct/(magnitude1 * magnitude2);
	}

	private static HashMap<Character, Integer> getCharIntMap(String s1,
			String s2) {
		TreeSet<Character> s1Chars = getChars(s1);
		TreeSet<Character> s2Chars = getChars(s2);
		TreeSet<Character> allChars = new TreeSet<Character>();
		allChars.addAll(s1Chars);
		allChars.addAll(s2Chars);
		int index = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		Iterator<Character> it = allChars.iterator();
		while (it.hasNext()) {
			Character c = it.next();
			map.put(c, index++);
		}
		return map;
	}

	private static TreeSet<Character> getChars(String s) {
		TreeSet<Character> sChars = new TreeSet<Character>();
		for (char c : s.toCharArray()) {
			sChars.add(c);
		}
		return sChars;
	}
	
	// from:
	// http://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Longest_common_substring#Java
	// GNU license
	public static int longestSubstr(String first, String second) {
		if (first == null || second == null || first.length() == 0 ||
			second.length() == 0) {
			return 0;
		}

		int maxLen = 0;
		int fl = first.length();
		int sl = second.length();
		int[][] table = new int[fl + 1][sl + 1];

		for (int s = 0; s <= sl; s++)
			table[0][s] = 0;
		for (int f = 0; f <= fl; f++)
			table[f][0] = 0;

		for (int i = 1; i <= fl; i++) {
			for (int j = 1; j <= sl; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					if (i == 1 || j == 1) {
						table[i][j] = 1;
					} else {
						table[i][j] = table[i - 1][j - 1] + 1;
					}
					if (table[i][j] > maxLen) {
						maxLen = table[i][j];
					}
				}
			}
		}
		return maxLen;
	}

	// SIFT3 code from https://github.com/konradbloor/mailcheck-java/blob/master/src/main/java/com/intercognition/mailcheck/stringdistance/Sift3.java
	// original license is MIT: https://github.com/ramitos/sift3
	public static float getDistance(String firstString, String secondString,
			int maxOffset) {
		if (isNullOrEmpty(firstString))
			return isNullOrEmpty(secondString) ? 0 : secondString.length();
		if (isNullOrEmpty(secondString))
			return firstString.length();

		int c = 0;
		int offset1 = 0;
		int offset2 = 0;
		int lcs = 0;

		while (c + offset1 < firstString.length() &&
			(c + offset2 < secondString.length())) {
			if (firstString.charAt(c + offset1) == secondString.charAt(c +
				offset2))
				lcs++;
			else {
				offset1 = 0;
				offset2 = 0;
				for (int i = 0; i < maxOffset; i++) {
					if ((c + i < firstString.length()) &&
						(firstString.charAt(c + i) == secondString.charAt(c))) {
						offset1 = i;
						break;
					}
					if ((c + i < secondString.length()) &&
						(firstString.charAt(c) == secondString.charAt(c + i))) {
						offset2 = i;
						break;
					}
				}
			}
			c++;
		}
		return (firstString.length() + secondString.length()) / 2.0f - lcs;
	}

	private static boolean isNullOrEmpty(String candidate) {
		return candidate == null || candidate.length() == 0;
	}

}
