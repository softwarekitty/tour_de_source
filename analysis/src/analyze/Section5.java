package analyze;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;

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
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InterruptedException, IllegalArgumentException, QuoteRuleException, PythonParsingException {
		String behavioral_analysis_path = PaperWriter.homePath +
			"analysis/behavioral_clustering/";
		
		ArrayList<WeightRankedRegex> corpus = IOUtil.importCorpus(PaperWriter.homePath+"analysis/analysis_output/exportedCorpusRaw.txt");
		//HashMap<String, Integer> dummyCounter = new HashMap<String, Integer>();
		//int[] dummyTracker = {0};
		//Section1.initializeCorpus(PaperWriter.connectionString, dummyTracker, corpus, dummyTracker, dummyTracker, dummyTracker, dummyCounter);

		//to debug some problem...
		//String debugCorpus = PaperWriter.exportCorpus(corpus);
		//IOUtil.createAndWrite(new File(behavioral_analysis_path,"debugCorpus.txt"), debugCorpus);
		
		
		String fullInputFilePath = behavioral_analysis_path + "behavioralSimilarityGraph.abc";
		DecimalFormat df = new DecimalFormat("0.00");
		
		//recommended values to try for i:
		double[] iVals ={1.1,1.2,1.3,1.4};
		for(double i_value : iVals){
			double pVals[] = {0.75};
			for(double p_value : pVals){
				int[] kVals = {100};
				for(int k_value : kVals){
					String suffix = "_i"+df.format(i_value)+"_p"+df.format(p_value)+"_k"+k_value+"_";
					String fullOutputFilePath = behavioral_analysis_path + "behavioralSimilarityClusters"+suffix+".txt";
					String newOptions = " -tf gq("+df.format(p_value)+") -tf #knn("+k_value+")";
					//String[] mclInput = {fullInputFilePath,"-I",df.format(i_value), "--abc","-o", fullOutputFilePath};
					String mclInput = fullInputFilePath+" -I "+df.format(i_value)+newOptions+" --abc -o " +fullOutputFilePath;
					TreeSet<Cluster> behavioralClusters = IOUtil.getClustersFromFile(fullInputFilePath, corpus, fullOutputFilePath, Integer.MAX_VALUE, mclInput);
					IOUtil.dumpAllClusters(behavioral_analysis_path, behavioralClusters, corpus,"behavioralSimilarityClusterDump"+suffix+".txt", suffix);
				}
			}	
		}
	}


}
