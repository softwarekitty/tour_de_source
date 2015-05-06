package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section5 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) {

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {

		return "";
	}

	// after getting the behavioral graph in csharp,
	// output a human-readable dump of clusters found.
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		String analysis_output_path = PaperWriter.homePath +
			"analysis/analysis_output/";
		
		ArrayList<WeightRankedRegex> corpus = new ArrayList<WeightRankedRegex>();
		HashMap<String, Integer> dummyCounter = new HashMap<String, Integer>();
		int[] dummyTracker = {0};
		Section1.initializeCorpus(PaperWriter.connectionString, dummyTracker, corpus, dummyTracker, dummyTracker, dummyTracker, dummyCounter);

		//to debug some problem...
		String debugCorpus = PaperWriter.exportCorpus(corpus);
		IOUtil.createAndWrite(new File(analysis_output_path,"debugCorpus.txt"), debugCorpus);
		
		
		String fullInputFilePath = analysis_output_path + "behavioralSimilarityGraph.abc";
		DecimalFormat df = new DecimalFormat("0.00");
		double base_i = 2.6;
		double increment = 0.3;
		for(int i=0;i<10;i++){
			double i_value = base_i + i*increment;
			String fullOutputFilePath = analysis_output_path + "behavioralSimilarityClusters_i_"+df.format(i_value)+"_"+".txt";
			TreeSet<Cluster> behavioralClusters = IOUtil.getClustersFromFile(fullInputFilePath, corpus, fullOutputFilePath, Integer.MAX_VALUE, i_value);
			IOUtil.dumpAllClusters(analysis_output_path, behavioralClusters, corpus,"behavioralSimilarityClusterDump_i_"+df.format(i_value)+"_"+".txt", i_value);
		}
	}	
}
