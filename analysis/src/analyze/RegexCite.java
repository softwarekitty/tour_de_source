package analyze;

import metric.FeatureCount;

import org.antlr.runtime.tree.CommonTree;
import org.python.util.PythonInterpreter;

import pcre.PCRE;

public final class RegexCite implements Comparable<RegexCite> {
	private final String pattern;
	private final CommonTree rootTree;

	public String getPattern() {
		return pattern;
	}

	private final FeatureCount features;
	private final int weight;

	public RegexCite(String pattern, int weight) {
		if (pattern == null) {
			throw new IllegalArgumentException("pattern cannot be null");
		} else if ("".equals(pattern)) {
			throw new IllegalArgumentException("pattern cannot be empty");
		} else {

			// forget it - this makes up a small portion and may change
			// behavior.
			// better to treat all of these strings equally
			// //remove the "u" that is part of python Strings, but not valid
			// input to PCRE
			// if (pattern.startsWith("u'") && pattern.length()>2 &&
			// pattern.charAt(pattern.length() - 1) == '\'') {
			// pattern = pattern.substring(1);
			// }
			this.pattern = pattern;
			this.weight = weight;

			// make sure the pattern is a valid regex
			PythonInterpreter interpreter = new PythonInterpreter();
			interpreter.exec("import re");
			interpreter.exec("x = re.compile(" + pattern + ")");

			// parse into the commontree
			this.rootTree = new PCRE(pattern).getCommonTree();
			this.features = new FeatureCount(rootTree);
		}
	}

	public CommonTree getRootTree() {
		return rootTree;
	}

	public FeatureCount getFeatures() {
		return features;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(RegexCite other) {
		return this.pattern.compareTo(other.pattern);
	}

	@Override
	public String toString() {
		return "RegexCite [pattern=" + pattern + "]";
	}

}
