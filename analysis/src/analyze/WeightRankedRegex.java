package analyze;

import metric.FeatureCount;

import org.antlr.runtime.tree.CommonTree;
import org.python.util.PythonInterpreter;

import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;
import pcre.PCRE;

public final class WeightRankedRegex implements RankableContent {
	private final String pattern;
	private final CommonTree rootTree;

	private final FeatureCount features;
	private final int weight;
	private String unescaped;

	public WeightRankedRegex(String pattern, int weight) throws QuoteRuleException, IllegalArgumentException, PythonParsingException {
		if (pattern == null) {
			throw new IllegalArgumentException("pattern cannot be null: "+pattern);
		} 
		this.unescaped = getUnescapedPythonPattern(pattern);
		
		if ("".equals(unescaped)) {
			throw new IllegalArgumentException("pattern cannot be empty: "+pattern);
		} else {
			this.pattern = pattern;
			this.weight = weight;

			try{
				
				// make sure the pattern is a valid regex
				PythonInterpreter interpreter = new PythonInterpreter();
				interpreter.exec("import re");
				interpreter.exec("x = re.compile(" + pattern + ")");
			}catch(Exception e){
				throw new PythonParsingException("Failure when trying to compile pattern in Python: "+pattern);
			}


			// parse into the commontree
			this.rootTree = new PCRE(getUnescapedPattern()).getCommonTree();
			this.features = new FeatureCount(rootTree,pattern);
		}
	}

	public CommonTree getRootTree() {
		return rootTree;
	}

	public FeatureCount getFeatures() {
		return features;
	}

	public int getRankableValue() {
		return weight;
	}

	@Override
	public int compareTo(RankableContent other) {
		if (other.getClass() != this.getClass()) {
			System.err.println("class mismatch");
			return 1;
		}
		WeightRankedRegex wrrOther = (WeightRankedRegex) other;
		// higher weight is earlier
		if (this.weight > wrrOther.weight) {
			return -1;
		} else if (this.weight < wrrOther.weight) {
			return 1;
		} else {
			// shorter length is earlier
			if (this.pattern.length() > wrrOther.pattern.length()) {
				return 1;
			} else if (this.pattern.length() < wrrOther.pattern.length()) {
				return -1;
			} else {

				// same weight and length: by hashcode
				return this.pattern.compareTo(wrrOther.pattern);
			}
		}
	}

	@Override
	public String toString() {
		return "WeightRankedRegex [pattern=" + pattern + "]";
	}

	@Override
	public String getContent() {
		return pattern;
	}
	
	public String getUnescapedPattern(){
		return this.unescaped;
	}

	private static String getUnescapedPythonPattern(String pat) throws QuoteRuleException {

		// python can do: u'...', ur'...', r'...'
		String removedUR = pat.startsWith("ur") ? pat.substring(2)
				: pat;
		if(removedUR.length()==0){
			return "";
		}
		String removedPrefix = (removedUR.startsWith("u") || removedUR.startsWith("r")) ? removedUR.substring(1)
				: removedUR;
		if(removedPrefix.length()<2){
			return "";
		}
		char firstChar = removedPrefix.charAt(0);
		char lastChar = removedPrefix.charAt(removedPrefix.length() - 1);
		char singleQuote = '\'';
		char doubleQuote = '"';

		if (!(firstChar == singleQuote && lastChar == singleQuote) &&
			!(firstChar == doubleQuote && lastChar == doubleQuote)) {
			throw new QuoteRuleException("the pattern: " + pat +
				" does not conform to the expected quotation rules");
		}
		String unQuoted = null;
		String trippleSingleQuote = "'''";
		String trippleDoubleQuote = "\"\"\"";
		if (isTripple(removedPrefix, trippleSingleQuote) ||
			isTripple(removedPrefix, trippleDoubleQuote)) {
			unQuoted = removeQuotes(removedPrefix, 3);
		} else {
			unQuoted = removeQuotes(removedPrefix, 1);
		}
		if(unQuoted.length()==0){
			return "";
		}
		String unescaped = unQuoted.replaceAll("\\\\\\\\", "\\\\");
		return unescaped;
	}

	private static String removeQuotes(String s, int i) {
		return s.substring(i, s.length() - i);
	}

	private static boolean isTripple(String s, String tripple) {
		if (s.length() < 6) {
			return false;
		}
		int threeFromEnd = s.length() - 3;
		return s.startsWith(tripple) &&
			s.substring(threeFromEnd).equals(tripple);
	}
	
	public static void main(String[] args) throws QuoteRuleException{
		String r = "'^(boot(\\\\.\\\\d+)?$|kernel\\\\.)'";
		System.out.println(r);
		System.out.println(getUnescapedPythonPattern(r));
	}
}