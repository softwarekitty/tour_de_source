package metric;


import java.util.Arrays;

public class FeatureSetClass {
	private final boolean[] isFeaturePresentArray;

	public FeatureSetClass(FeatureCount fc) {
		int[] featureCountArray = fc.getFeatureCountArray();
		isFeaturePresentArray = new boolean[featureCountArray.length];

		for (int i = 0; i < featureCountArray.length; i++) {
			isFeaturePresentArray[i] = featureCountArray[i] > 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(isFeaturePresentArray);
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
		FeatureSetClass other = (FeatureSetClass) obj;
		if (!Arrays.equals(isFeaturePresentArray, other.isFeaturePresentArray))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeatureSetClass [isFeaturePresentArray="
				+ Arrays.toString(isFeaturePresentArray) + "]";
	}

	public String diff(FeatureSetClass other) {
		if (this.equals(other)) {
			return "[no difference]";
		}
		FeatureDictionary featureDictionary = new FeatureDictionary();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < isFeaturePresentArray.length; i++) {
			if (this.isFeaturePresentArray[i] != other.isFeaturePresentArray[i]) {
				sb.append(": (" + featureDictionary.getName(i) + " - this: "
						+ this.isFeaturePresentArray[i] + ", other: "
						+ other.isFeaturePresentArray[i] + ") :");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
