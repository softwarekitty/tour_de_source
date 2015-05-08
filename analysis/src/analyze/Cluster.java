package analyze;

import java.util.Iterator;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Cluster extends TreeSet<WeightRankedRegex> implements RankableContent{
	
	private int combinedWeight;
	private int topN;
	
	public Cluster(int topN){
		super();
		this.topN = topN;
		combinedWeight =0;
	}
	
	@Override
	public boolean add(WeightRankedRegex x){
		combinedWeight += x.getRankableValue();
		return super.add(x);
	}

	@Override
	public int getRankableValue() {
		return combinedWeight;
	}

	@Override
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRankedRegex> it = this.iterator();
		int i=0;
		if(it.hasNext()){
			WeightRankedRegex x = it.next();
			sb.append(x.getContent()+"::"+x.getRankableValue());
			i++;
		}
		while(it.hasNext() && i<topN){
			WeightRankedRegex x = it.next();
			sb.append(",");
			sb.append(x.getContent()+"::"+x.getRankableValue());
			i++;
		}
		return sb.toString();
	}
	
	public String getShortest(){
		Iterator<WeightRankedRegex> it = this.iterator();
		String smallest = null;
		if(it.hasNext()){
			
			//should always get here - no empty clusters
			smallest = it.next().getUnescapedPattern();
		}
		while(it.hasNext()){
			String smaller = it.next().getUnescapedPattern();
			if(smaller.length() < smallest.length()){
				smallest = smaller;
			}
		}
		return smallest;
	}

	@Override
	public int compareTo(RankableContent other) {
		if(other.getClass()!=this.getClass()){
			System.err.println("class mismatch");
			return 1;
		}
		Cluster cOther = (Cluster)other;
		//higher weight is earlier
		if(this.combinedWeight > cOther.combinedWeight){
			return -1;
		}else if(this.combinedWeight < cOther.combinedWeight){
			return 1;
		}else{
			String myContent = this.getContent();
			String otherContent = cOther.getContent();
			//shorter length is earlier
			if(myContent.length() > otherContent.length()){
				return 1;
			}else if(myContent.length() < otherContent.length()){
				return -1;
			}else{
				
				//same weight and length: by hashcode
				return myContent.compareTo(otherContent);
			}
		}
	}
}
