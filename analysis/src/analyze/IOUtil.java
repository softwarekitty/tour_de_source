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
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

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
	public static TreeSet<Cluster> getClusters(
			String outputPath, String filename, String contents,
			List<WeightRankedRegex> corpus, int topN) throws IOException,
			InterruptedException {
		// create the file for mcl to use as input
		File f = new File(outputPath + filename);
		IOUtil.createAndWrite(f, contents);

		// run the mcl script
		Process p = Runtime.getRuntime().exec("/usr/local/bin/mcl " +
			outputPath + filename + " --abc -o " + outputPath + "mclOutput_" +
			filename);
		p.waitFor();

		// parse mcl output
		TreeSet<Cluster> clusters = new TreeSet<Cluster>();
		File outputFile = new File(outputPath + "mclOutput_" + filename);
		List<String> lines = FileUtils.readLines(outputFile, "UTF-8");
		for(String line : lines){
			String[] indices = line.split("\t");
			if(indices.length==0){
				continue;
			}
			Cluster cluster = new Cluster(topN);
			for(String index : indices){
				cluster.add(corpus.get(Integer.parseInt(index)));
			}
			clusters.add(cluster);
		}
		return clusters;
	}
}
