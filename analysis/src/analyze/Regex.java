package analyze;

import java.text.ParseException;

import metric.FeatureCount;

import org.antlr.runtime.tree.CommonTree;
import org.python.util.PythonInterpreter;

import pcre.PCRE;

public final class Regex implements Comparable<Regex> {
	private final String pattern;
	private final CommonTree rootTree;
	private final FeatureCount features;
	private final int weight;

	public Regex(String pattern, int weight) {
		this.pattern = pattern;
		this.weight = weight;
		if (pattern == null) {
			throw new IllegalArgumentException("pattern cannot be null");
		} else if ("".equals(pattern)) {
			throw new IllegalArgumentException("pattern cannot be empty");
		} else {
			// make sure the pattern is a valid regex
			PythonInterpreter interpreter = new PythonInterpreter();
			interpreter.exec("import re");
			interpreter.exec("x = re.compile('" + pattern + "')");

			// parse into the commontree
			this.rootTree = new PCRE(pattern).getCommonTree();
			this.features = new FeatureCount(rootTree);
		}
	}

	@Override
	public int compareTo(Regex other) {
		return this.pattern.compareTo(other.pattern);
	}
}
