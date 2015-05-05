package analyze;

public class FeatureDetail implements RankableContent{
	private final int featureID;
	private final int weight;
	private final int tokens;
	private final int present;
	private final int max;
	
	public FeatureDetail(int featureID, int tokens, int present, int weight, int max){
		this.featureID = featureID;
		this.weight = weight;
		this.tokens = tokens;
		this.present = present;
		this.max = max;
	}

	@Override
	public int getRankableValue() {
		return weight;
	}

	@Override
	public String getContent() {
		return "feature detail "+featureID;
	}

	@Override
	public int compareTo(RankableContent o) {
		if(this.getClass()!=o.getClass()){
			throw new RuntimeException("FeatureDetail requires comparison with another FeatureDetail");
		}
		FeatureDetail other = (FeatureDetail)o;
		if(this.weight > other.weight){
			return -1;
		}else if(this.weight < other.weight){
			return 1;
		}else if(this.featureID > other.featureID){
			return -1;
		}else if(this.featureID < other.featureID){
			return 1;
		}else{
			return 0;
		}
	}

	public int getID() {
		return featureID;
	}

	public int getTokens() {
		return tokens;
	}

	public int getPresent() {
		return present;
	}

	public int getMax() {
		return max;
	}

}
