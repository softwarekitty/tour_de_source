package metric;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;

import pcre.PCREParser;

public class FeatureCount {
	private static FeatureDictionary featureDictionary = new FeatureDictionary();

	private final int[] featureCountArray;
	
	
	public int[] getFeatureCountArray(){
		int length = featureCountArray.length;
		int [] copy = new int[length];
		System.arraycopy(featureCountArray, 0, copy, 0, length);
		return copy;
	}
	
	public int getDistinctFeatureCount(){
		int nDistinctFeatures = 0;
		for(int nParsedTokens : featureCountArray){
			if(nParsedTokens>0){
				nDistinctFeatures++;
			}
		}
		return nDistinctFeatures;
	}
	
	public int getTokenCount(){
		int tokenCount = 0;
		for(int nParsedTokens : featureCountArray){
			tokenCount += nParsedTokens;
		}
		return tokenCount;
	}

	public FeatureCount(CommonTree tree) throws AlienFeatureException{
		this(treeToIndexCountMap(tree));
	}

	// requires all keys to be in the range [0,featureDictionary.getSize())
	public FeatureCount(Map<Integer, Integer> indexCountMap) {
		featureCountArray = new int[featureDictionary.getSize()];
		Set<Entry<Integer, Integer>> entries = indexCountMap.entrySet();
		for (Entry<Integer, Integer> entry : entries) {
			featureCountArray[entry.getKey()] = entry.getValue();
		}
	}

	@SuppressWarnings("unchecked")
	private static Map<Integer, Integer> treeToIndexCountMap(CommonTree treeRoot) throws AlienFeatureException{
		CountMap indexCountMap = new CountMap();

		List<CommonTree> firstStack = new ArrayList<CommonTree>();
		firstStack.add(treeRoot);

		List<List<CommonTree>> childListStack = new ArrayList<List<CommonTree>>();
		childListStack.add(firstStack);

		while (!childListStack.isEmpty()) {

			List<CommonTree> childStack = childListStack.get(childListStack
					.size() - 1);

			if (childStack.isEmpty()) {
				childListStack.remove(childListStack.size() - 1);
			} else {
				CommonTree subTree = childStack.remove(0);
				incrementCount(subTree, indexCountMap);
				if (subTree.getChildCount() > 0) {
					childListStack.add(new ArrayList<CommonTree>(
							(List<CommonTree>) subTree.getChildren()));
				}
			}
		}
		return indexCountMap;
	}

	private static void incrementCount(CommonTree tree, CountMap indexCountMap) throws AlienFeatureException{
		List<String> ignoreList = Arrays.asList("","LAZY","QUANTIFIER","NUMBER","GREEDY","ALTERNATIVE","ELEMENT");
		String tokenName = "";
		if (tree.getType() == PCREParser.REPETITION_TYPE) {
			tokenName = tree.getText();
		} else {
			tokenName = PCREParser.tokenNames[tree.getType()];
		}
		// System.out.println("tokenName: "+tokenName);
		int featureIndex = featureDictionary.getIndex(tokenName);

		// it is some valid feature index that maps directly
		if (featureIndex >= 0) {
			indexCountMap.increment(featureIndex);
		} else if (!ignoreList.contains(tokenName)){
			throw new AlienFeatureException("found unsupported feature: "
					+ PCREParser.tokenNames[tree.getType()]);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(featureCountArray);
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
		FeatureCount other = (FeatureCount) obj;
		if (!Arrays.equals(featureCountArray, other.featureCountArray))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeatureCount [featureCountArray="
				+ Arrays.toString(featureCountArray) + "]";
	}
}
