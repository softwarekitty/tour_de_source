package analyze;

public class CoAppearance implements RankableContent {
	private final int nAppearances;
	private final String pairName;
	private final String examplePattern;

	public CoAppearance(int nAppearances, String pairName, String examplePattern) {
		this.nAppearances = nAppearances;
		this.pairName = pairName;
		this.examplePattern = examplePattern;
	}

	@Override
	public int getRankableValue() {
		return nAppearances;
	}

	@Override
	public String getContent() {
		return pairName;
	}
	
	public String getExample() {
		return examplePattern;
	}

	@Override
	public int compareTo(RankableContent other) {
		if (other.getClass() != this.getClass()) {
			System.err.println("class mismatch");
			return 1;
		}
		CoAppearance caOther = (CoAppearance) other;
		// higher nAppearances is earlier
		if (this.nAppearances > caOther.nAppearances) {
			return -1;
		} else if (this.nAppearances < caOther.nAppearances) {
			return 1;
		} else {
			// by hashcode
			return this.pairName.compareTo(caOther.pairName);
		}
	}
}
