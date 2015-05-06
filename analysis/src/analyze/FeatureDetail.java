package analyze;

public class FeatureDetail implements RankableContent{
	private final int featureID;
	private final int nProjects;
	private final int nFiles;
	private final int nPresent;
	private final int max;
	private final int nTokens;
	
	public FeatureDetail(int featureID, int nFiles, int nPresent, int nProjects, int max, int nTokens){
		this.featureID = featureID;
		this.nProjects = nProjects;
		this.nFiles = nFiles;
		this.nPresent = nPresent;
		this.max = max;
		this.nTokens = nTokens;
	}

	@Override
	public int getRankableValue() {
		return nProjects;
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
		if(this.nProjects > other.nProjects){
			return -1;
		}else if(this.nProjects < other.nProjects){
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

	public int getnFiles() {
		return nFiles;
	}

	public int getnPresent() {
		return nPresent;
	}

	public int getMax() {
		return max;
	}
	
	public int getnTokens() {
		return nTokens;
	}


}
