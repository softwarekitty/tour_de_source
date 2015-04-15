package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
// import org.rosuda.JRI.Rengine;
// import org.rosuda.JRI.REXP;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
// c.execute('''CREATE TABLE RegexCitation (uniqueSourceID int, sourceJSON text,
// fileHash char(44), filePath text, pattern text, flags int, regexFunction
// int)''')
// c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')

public class PaperWriter {
	private static ArrayList<WeightRankedRegex> corpus;

	// the delimiter character for our 'csv' files used by latex
	private static char d = '•';

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, ValueMissingException, IOException,
			InterruptedException {
		System.out.println("begin paper writer");
		corpus = new ArrayList<WeightRankedRegex>(1024);

		// initialize
		String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/";
		String connectionString = "jdbc:sqlite:" + homePath +
			"tools/merged/merged_report.db";

		// populate the map with keys for the Latex database
		HashMap<String, String> databaseFileContent = new HashMap<String, String>();
		populateTexDatabase(databaseFileContent, connectionString);

		// Below here we are making files
		List<NameContentsPair> filesToMake = new LinkedList<NameContentsPair>();

		// An R script to make images
		filesToMake.add(new NameContentsPair(C.R_SCRIPTNAME, createImagesScript(connectionString, homePath, databaseFileContent)));

		// create the table showing source,Q1,Avg,Med,Q3,Max for
		// filesPerProject, rFilesPerProject, regexPerFile
		filesToMake.add(new NameContentsPair("contextHistogram.tex", Composer.composeHistogramTable(3, Section0.getContextStatsAndAddToDatabase(connectionString, databaseFileContent))));

		// make a latex table with the top N regexes by weight.
		filesToMake.add(new NameContentsPair("topNW.tex", Composer.composeRegexTable(10, corpus.iterator(), 2.3)));

		// create the table showing source,Q1,Avg,Med,Q3,Max for pattern weight,
		// distinct features, token count and pattern length
		filesToMake.add(new NameContentsPair("characterHistogram.tex", Composer.composeHistogramTable(4, Section1.getCharacterStatsAndAddToDatabase(databaseFileContent, corpus))));

		// the key value database for strings in the paper
		filesToMake.add(new NameContentsPair("database.csv", stringifyMap(databaseFileContent)));

		// stats about how features are used
		filesToMake.add(new NameContentsPair("featureStats.tex", Section2.featureStats(corpus,databaseFileContent)));
		
		// createContent
		generateArtifacts(filesToMake, homePath);
		System.out.println("finished paper writer");
	}

	private static void generateArtifacts(List<NameContentsPair> filesToMake,
			String homePath) throws IOException, InterruptedException {

		// clean the old output, if any
		String outputPath = homePath + "analysis/analysis_output/";
		FileUtils.cleanDirectory(new File(outputPath));

		// create all files using the list of name, contents
		for (NameContentsPair ncp : filesToMake) {
			File f = new File(outputPath + ncp.getFilename());
			IOUtil.createAndWrite(f, ncp.getContents());
		}

		// run the R script
		Process p = Runtime.getRuntime().exec("/usr/local/bin/R CMD BATCH " +
			outputPath + C.R_SCRIPTNAME);

		// add + " /dev/null" to the end to silence output
		p.waitFor();
	}

	// note this depends heavily on databaseFileContent populating
	// having fields poplated in order.
	private static String createImagesScript(String connectionString,
			String homePath, HashMap<String, String> databaseFileContent)
			throws ClassNotFoundException, SQLException {

		StringBuilder rString = new StringBuilder();
		rString.append(Section0.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section1.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section2.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section3.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section4.contributeRString(databaseFileContent, connectionString, homePath));
		rString.append(Section5.contributeRString(databaseFileContent, connectionString, homePath));
		return rString.toString();
	}

	private static void populateTexDatabase(
			HashMap<String, String> databaseFileContent, String connectionString)
			throws ClassNotFoundException, SQLException, ValueMissingException {
		Section0.contributeToMap(databaseFileContent, connectionString);
		Section1.contributeToMap(databaseFileContent, connectionString, corpus);
		Section2.contributeToMap(databaseFileContent, connectionString);
		Section3.contributeToMap(databaseFileContent, connectionString);
		Section4.contributeToMap(databaseFileContent, connectionString);
		Section5.contributeToMap(databaseFileContent, connectionString);
	}

	private static String stringifyMap(HashMap<String, String> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("key" + d + "value\n");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> e : entrySet) {
			sb.append(e.getKey());
			sb.append(d);
			sb.append(e.getValue() + "\n");
		}
		return sb.toString();
	}

}
