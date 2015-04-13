package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
// import org.rosuda.JRI.Rengine;
// import org.rosuda.JRI.REXP;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
// c.execute('''CREATE TABLE RegexCitation (uniqueSourceID int, sourceJSON text,
// fileHash char(44), filePath text, pattern text, flags int, regexFunction
// int)''')
// c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')

public class PaperWriter {
	private static ArrayList<RegexCite> corpus;

	// the delimiter character for our 'csv' files used by latex
	private static char d = '•';

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, ValueMissingException, IOException,
			InterruptedException {
		System.out.println("begin paper writer");
		corpus = new ArrayList<RegexCite>(1024);

		// initialize
		String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/";
		String connectionString = "jdbc:sqlite:" + homePath +
			"tools/merged/merged_report.db";

		// populate the map with keys for the Latex database
		HashMap<String, String> databaseFileContent = new HashMap<String, String>();
		populateTexDatabase(databaseFileContent, connectionString);

		// create the R script content for image creation
		String rScriptContent = createImagesScript(connectionString, homePath, databaseFileContent);

		// create the table showing Q1,Med,Q3, Max for filesPerProject,
		// rFilesPerProject, regexPerFile
		String contextQuartilesFileContent = createContextQuartilesContent(databaseFileContent);
		String top10byWeightContent = getTopNByWeightContent(10);

		// createContent
		generateArtifacts(stringifyMap(databaseFileContent), contextQuartilesFileContent, top10byWeightContent, rScriptContent, homePath);
		System.out.println("finished paper writer");
	}

	private static String getTopNByWeightContent(int n) {
		StringBuilder sb = new StringBuilder();
		TreeSet<RegexCite> sortedCorpus = new TreeSet<RegexCite>();
		sortedCorpus.addAll(corpus);
		Iterator<RegexCite> it = sortedCorpus.iterator();
		sb.append("pattern•weight\n");
		for (int i = 0; i < n; i++) {
			if (it.hasNext()) {
				RegexCite rc = it.next();
				sb.append(rc.getPattern() + d + rc.getWeight() + "\n");
			}
		}
		return sb.toString();
	}

	private static String createContextQuartilesContent(
			HashMap<String, String> databaseFileContent) {
		StringBuilder sb = new StringBuilder();
		//		sb.append("source•Q1•Avg•Med•Q3•Max\n");

		sb.append("source•Q1•Med•Q3•Max\n");
		sb.append("files per project" + d +
			databaseFileContent.get(C.Q1_FILE_PER_PROJECT) + d +
			databaseFileContent.get(C.MED_FILE_PER_PROJECT) + d +
			databaseFileContent.get(C.Q3_FILE_PER_PROJECT) + d +
			databaseFileContent.get(C.MAX_FILE_PER_PROJECT) + "\n");
		sb.append("files with regex per project" + d +
			databaseFileContent.get(C.Q1_RFILE_PER_PROJECT) + d +
			databaseFileContent.get(C.MED_RFILE_PER_PROJECT) + d +
			databaseFileContent.get(C.Q3_RFILE_PER_PROJECT) + d +
			databaseFileContent.get(C.MAX_RFILE_PER_PROJECT) + "\n");
		sb.append("regex usages per file" + d +
			databaseFileContent.get(C.Q1_R_PER_FILE) + d +
			databaseFileContent.get(C.MED_R_PER_FILE) + d +
			databaseFileContent.get(C.Q3_R_PER_FILE) + d +
			databaseFileContent.get(C.MAX_R_PER_FILE) + "\n");
		return sb.toString();
	}

	private static void generateArtifacts(String databaseFileContent,
			String contextQuartilesFileContent, String top10byWeightContent,
			String rScriptContent, String homePath) throws IOException,
			InterruptedException {

		//
		// create the output file objects
		String scriptName = "analysis_script.r";
		String databaseName = "database.csv";
		String contextQuartilesName = "contextQuartiles.csv";
		String topNByWeightName = "topNW.csv";
		String outputPath = homePath + "analysis/analysis_output/";
		File dbFile = new File(outputPath + databaseName);
		File contextQuartilesTable = new File(outputPath + contextQuartilesName);
		File top10WFile = new File(outputPath + topNByWeightName);
		File rFile = new File(outputPath + scriptName);
		FileUtils.cleanDirectory(new File(outputPath));

		IOUtil.createAndWrite(dbFile, databaseFileContent);
		IOUtil.createAndWrite(contextQuartilesTable, contextQuartilesFileContent);
		IOUtil.createAndWrite(top10WFile, top10byWeightContent);
		IOUtil.createAndWrite(rFile, rScriptContent);

		// run the R script
		Process p = Runtime.getRuntime().exec("/usr/local/bin/R CMD BATCH " +
			outputPath + scriptName);

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
		sb.append("key•value\n");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> e : entrySet) {
			sb.append(e.getKey());
			sb.append(d);
			sb.append(e.getValue() + "\n");
		}
		return sb.toString();
	}

}
