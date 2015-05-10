package analyze;

import java.util.TreeSet;

import metric.FeatureDictionary;

public class FeaturePile extends TreeSet<RankedFeature>{
	private static final long serialVersionUID = 1L;
	public static FeatureDictionary fd = new FeatureDictionary();
	private final int[] featureCountArray;
	
	public FeaturePile(Cluster cluster){
		super();
		this.featureCountArray = new int[fd.getSize()];
		for (WeightRankedRegex wrr : cluster) {
			int[] fc = wrr.getFeatures().getFeatureCountArray();
			for (int featureIndex = 0; featureIndex < featureCountArray.length; featureIndex++) {
				featureCountArray[featureIndex] += fc[featureIndex];
			}
		}

		double nPatterns = cluster.size();
		for (int featureIndex = 0; featureIndex < featureCountArray.length; featureIndex++) {
			String featureText = fd.getCode(featureIndex) + "|" +
				fd.getDescription(featureIndex);
			this.add(new RankedFeature(featureIndex, featureText, featureCountArray[featureIndex] /
				nPatterns));
		}
	}

	public boolean containsFeatureIndex(int featureIndex) {
		return featureCountArray[featureIndex]!=0;
	}
}
