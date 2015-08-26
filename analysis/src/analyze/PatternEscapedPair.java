package analyze;

import analyze.exceptions.QuoteRuleException;

public class PatternEscapedPair implements Comparable<PatternEscapedPair>{
	private final String pattern;
	private final String unescaped;
	
	public PatternEscapedPair(String pattern) throws QuoteRuleException{
		this.pattern = pattern;
		String unquoted = WeightRankedRegex.getUnquotedPythonPattern(pattern);
		this.unescaped = WeightRankedRegex.getUnescaped(unquoted);
	}
	
	public String getPattern(){
		return pattern;
	}
	
	public String getUnescaped(){
		return unescaped;
	}

	@Override
	public int compareTo(PatternEscapedPair o) {
		int val = this.unescaped.compareTo(o.unescaped);
		return val;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result +
			((unescaped == null) ? 0 : unescaped.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatternEscapedPair other = (PatternEscapedPair) obj;
		if (unescaped == null) {
			if (other.unescaped != null)
				return false;
		} else if (!unescaped.equals(other.unescaped))
			return false;
		return true;
	}
}
