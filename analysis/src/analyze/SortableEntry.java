package analyze;

import java.util.TreeSet;

public class SortableEntry implements Comparable<SortableEntry>{
	private final PatternEscapedPair key;
	private final TreeSet<Integer> value;
	
	public SortableEntry(PatternEscapedPair key, TreeSet<Integer> value){
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(SortableEntry o) {
		return key.compareTo(o.key);
	}

	public PatternEscapedPair getKey() {
		return key;
	}
	
	public TreeSet<Integer> getValue(){
		return value;
	}

}
