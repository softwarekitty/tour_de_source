package analyze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.TreeSet;

import metric.FeatureDictionary;

import org.apache.commons.io.FileUtils;

import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;

public class IOUtil {

	public static String getFileContents(String filePath) {
		String contents = null;
		try {
			contents = FileUtils.readFileToString(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}

	public static ArrayList<WeightRankedRegex> importCorpus(
			String exportedCorpusRawPath) throws IllegalArgumentException,
			QuoteRuleException, PythonParsingException {

		//get only clean lines, each with 3 parts
		List<String> lines = IOUtil.getFileLines(exportedCorpusRawPath);
		Iterator<String> it = lines.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s == null || s.length() == 0 || !s.contains("\t") ||
				s.split("\t").length != 3) {
				it.remove();
			}
		}
		//turn these lines into the ArrayList
		WeightRankedRegex[] wrrArray = new WeightRankedRegex[lines.size()];
		for (String line : lines) {
			String[] args = line.split("\t");
			int index = Integer.parseInt(args[0]);
			int weight = Integer.parseInt(args[1]);
			String pattern = args[2].trim();
			wrrArray[index] = new WeightRankedRegex(pattern, weight);
			// corpus.set(index, new WeightRankedRegex(pattern,weight));
		}
		return new ArrayList<WeightRankedRegex>(Arrays.asList(wrrArray));
	}

	public static List<String> getFileLines(String filePath) {
		List<String> contentLines = new ArrayList<String>();
		contentLines.add("error content");
		Path path = Paths.get(filePath);
		try {
			contentLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentLines;
	}

	public static void createAndWrite(File file, String content) {
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void waitNsecsOrContinue(int x) {
		System.out.println("return to continue (within " + x + " seconds)");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long startTime = System.currentTimeMillis();
		try {
			while ((System.currentTimeMillis() - startTime) < x * 1000 &&
				!in.ready()) {
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (in.ready()) {
				System.out.println("You entered: " + in.readLine());
			} else {
				System.out.println("You did not enter data after " + x +
					" seconds");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static TreeSet<Cluster> getClusters(String outputPath,
			String filename, String contents,
			ArrayList<WeightRankedRegex> corpus, int topN, double i_value)
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		String fullInputFilePath = outputPath + filename;
		String fullOutputFilePath = outputPath + "mclOutput_" + filename;

		// create the file for mcl to use as input
		File f = new File(fullInputFilePath);
		IOUtil.createAndWrite(f, contents);

		DecimalFormat df = new DecimalFormat("0.00");
		String mclInput = fullInputFilePath + " -I " + df.format(i_value) +
			" --abc -o " + fullOutputFilePath;

		return getClustersFromFile(fullInputFilePath, corpus, fullOutputFilePath, topN, mclInput);

	}

	public static TreeSet<Cluster> getClustersFromFile(
			String fullInputFilePath, ArrayList<WeightRankedRegex> corpus,
			String fullOutputFilePath, int topN, String mclInput)
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		HashMap<Integer, WeightRankedRegex> lookup = getLookup(corpus);

		File outFile = new File(fullOutputFilePath);
		if (outFile.exists()) {
			outFile.delete();
		}

		// run the mcl script
		//System.out.println("mcl input: "+ Arrays.toString(mclInput));
		List<String> cmds = new ArrayList<String>(Arrays.asList(mclInput.split(" ")));
		System.out.println("mcl input: "+ mclInput);
		cmds.add(0, "/usr/local/bin/mcl");
		ProcessBuilder pb = new ProcessBuilder(cmds);
		Process p = pb.start();
		int x = p.waitFor();
		System.out.println("process int: "+x);
//		Process p = Runtime.getRuntime().exec("/usr/local/bin/mcl " + mclInput);
//		p.waitFor();
		
		

		// parse mcl output
		TreeSet<Cluster> clusters = new TreeSet<Cluster>();
		File outputFile = new File(fullOutputFilePath);
		List<String> lines = FileUtils.readLines(outputFile, "UTF-8");
		int lineNumber = 0;
		for (String line : lines) {
			String[] indices = line.split("\t");
			if (indices.length == 0) {
				continue;
			}
			Cluster cluster = new Cluster(topN);
			for (String index : indices) {
				int indexValue = Integer.parseInt(index);
				WeightRankedRegex wrr = lookup.get(indexValue);
				// System.out.print("lineNumber: "+lineNumber+" index: "+index+" indexValue: "+indexValue);
				// System.out.println(" pattern: "+wrr.getContent());
				cluster.add(wrr);
			}
			cluster.initialzeNProjects();
			clusters.add(cluster);
			lineNumber++;
		}
		return clusters;
	}

	public static void dumpAllClusters(String analysis_output_path,
			TreeSet<Cluster> behavioralClusters,
			ArrayList<WeightRankedRegex> corpus, String filename, String suffix) throws ClassNotFoundException, SQLException {
		FeatureDictionary fd = new FeatureDictionary();
		int totalPatterns = 0;
		int totalWeight = 0;
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.00");

		int i = 0;
		TreeSet<Integer> allProjectIDs = new TreeSet<Integer>();
		for (Cluster cluster : behavioralClusters) {
			if (cluster.size() == 1) {
				continue;
			}

			int[] featureCounter = new int[fd.getSize()];
			double nPatterns = 0;

			for (WeightRankedRegex wrr : cluster) {
				nPatterns++;
				int[] fc = wrr.getFeatures().getFeatureCountArray();
				for (int featureIndex = 0; featureIndex < featureCounter.length; featureIndex++) {
					featureCounter[featureIndex] += fc[featureIndex];
				}
			}

			TreeSet<RankedFeature> featurePile = new TreeSet<RankedFeature>();
			for (int featureIndex = 0; featureIndex < featureCounter.length; featureIndex++) {
				String featureText = fd.getCode(featureIndex) + "|" +
					fd.getDescription(featureIndex);
				featurePile.add(new RankedFeature(featureText, featureCounter[featureIndex] /
					nPatterns));
			}
			StringBuilder topNString = new StringBuilder();
			Iterator<RankedFeature> it = featurePile.iterator();
			int n=1;
			int topN = 10;
			boolean listAll = true;
			while (it.hasNext() && (listAll || n<=topN)) {
				RankedFeature rF = it.next();
				if(rF.getFrequency()==0){
					break;
				}
				topNString.append(rF.dump(n));
				n++;
			}
			sb.append("cluster " + i + " stats:\nnPatterns: " + nPatterns +
				"\nnProjects: " + cluster.getRankableValue() + "\nshortest: " +
				cluster.getShortest() + "\nFeatures:\n\n" +
				topNString.toString() + "\n\n");

			int j = 0;
			for (WeightRankedRegex wrr : cluster) {
				sb.append(wrr.dump(j, 4));
				j++;
			}
			sb.append("\n\n\n");
			i++;
			totalPatterns += nPatterns;
			allProjectIDs.addAll(cluster.getProjectIDs());
		}
		sb.insert(0, "Cluster stats:\n\nnClusters: " + i + "\nTotalPatterns: " +
			totalPatterns + "\ntotalnProjects: " + allProjectIDs.size() + "\nsuffix: " +
			suffix + "\n\n\n");
		File output = new File(analysis_output_path, filename);

		// delete the old version
		if (output.exists()) {
			output.delete();
		}
		createAndWrite(output, sb.toString());
	}

	public static HashMap<Integer, WeightRankedRegex> getLookup(
			ArrayList<WeightRankedRegex> corpus) {
		String filtered_corpus_path = PaperWriter.homePath +
			"csharp/filteredCorpus.txt";
		String content = IOUtil.getFileContents(filtered_corpus_path);

		HashMap<Integer, WeightRankedRegex> lookup = new HashMap<Integer, WeightRankedRegex>();
		Pattern finder = Pattern.compile("(\\d+)\\t(.*)");
		Matcher pairMatcher = finder.matcher(content);
		while (pairMatcher.find()) {

			Integer index = Integer.parseInt(pairMatcher.group(1));
			String pattern = pairMatcher.group(2);
			for (WeightRankedRegex wrr : corpus) {
				String unesc = wrr.getUnescapedPattern();
				// System.out.print(":::,:::"+unesc);
				if (unesc.equals(pattern)) {
					lookup.put(index, wrr);
					break;
				}
			}
			if (lookup.get(index) == null) {
				System.out.println("getLookup why did this fail?- index: " +
					index + " pattern:::" + pattern + ":::");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return lookup;
	}
}
