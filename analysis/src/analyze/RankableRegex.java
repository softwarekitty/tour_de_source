package analyze;

public interface RankableRegex extends Comparable<WeightRankedRegex>{
	
	public int getWeight();
	public String getPattern();
	public int compareTo(WeightRankedRegex other);

}
