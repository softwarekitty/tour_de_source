package analyze;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import org.rosuda.JRI.Rengine;
// import org.rosuda.JRI.REXP;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
// c.execute('''CREATE TABLE RegexCitation (uniqueSourceID int, sourceJSON text,
// fileHash char(44), filePath text, pattern text, flags int, regexFunction
// int)''')
// c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')

public class PaperWriter {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, ValueMissingException, IOException,
			InterruptedException {
		System.out.println("begin paper writer");

		// initialize
		String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/";
		String connectionString = "jdbc:sqlite:" + homePath +
			"tools/merged/merged_report.db";

		// populate the map with keys for the Latex database
		HashMap<String, Integer> databaseFileContent = new HashMap<String, Integer>();
		populateTexDatabase(databaseFileContent, connectionString);

		// create the R script content for image creation
		String rScriptContent = createImagesScript(connectionString, homePath);

		// createContent
		generateArtifacts(stringifyMap(databaseFileContent), rScriptContent, homePath);
		System.out.println("finished paper writer");
	}

	private static void generateArtifacts(String databaseFileContent,
			String rScriptContent, String homePath) throws IOException,
			InterruptedException {

		//
		// create the output file objects
		String scriptName = "analysis_script.r";
		String databaseName = "database.csv";
		String outputPath = homePath + "analysis/analysis_output/";
		File dbFile = new File(outputPath + databaseName);
		File rFile = new File(outputPath + scriptName);
		FileUtils.cleanDirectory(new File(outputPath));

		IOUtil.createAndWrite(dbFile, databaseFileContent);
		IOUtil.createAndWrite(rFile, rScriptContent);

		// run the R script
		Process p = Runtime.getRuntime().exec("/usr/local/bin/R CMD BATCH " +
			outputPath + scriptName + " /dev/null");
		p.waitFor();
	}

	private static String createImagesScript(String connectionString,
			String homePath) throws ClassNotFoundException, SQLException {
		// mostly following:
		// http://stackoverflow.com/questions/5142842
		StringBuilder rScriptContent = new StringBuilder();
		rScriptContent.append("\n");
		rScriptContent.append(getFilesPerProjectVector(connectionString));
		rScriptContent.append("setEPS()\n");
		rScriptContent.append("postscript(\"" + homePath +
			"analysis/analysis_output/filesPerProject.eps\")\n");
		rScriptContent.append("boxplot(filesPerProjectVector, ylab =\"ln(nFiles)\")\n");
		rScriptContent.append("dev.off()\n");
		rScriptContent.append("\n");
		return rScriptContent.toString();
	}

	private static String getFilesPerProjectVector(String connectionString)
			throws ClassNotFoundException, SQLException {
		// first we get the db data into memory
		HashMap<Integer, Integer> filesPerProjectMap = new HashMap<Integer, Integer>();

		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(connectionString);
		c.setAutoCommit(false);
		stmt = c.createStatement();

		// turn all the non-negative keys into pairs for R
		ResultSet rs = stmt.executeQuery("Select nFiles, frequency FROM FilesPerProjectMerged WHERE nFiles >= 0;");
		while (rs.next()) {
			filesPerProjectMap.put(rs.getInt("nFiles"), rs.getInt("frequency"));
		}

		// wind down sql
		rs.close();
		stmt.close();
		c.close();

		// now take your time looping through the data
		boolean firstNumber = true;
		StringBuilder sb = new StringBuilder();
		sb.append("filesPerProjectVector <- c(");
		for (Entry<Integer, Integer> entry : filesPerProjectMap.entrySet()) {
			int nFiles = entry.getKey();
			int frequency = entry.getValue();
			// maybe there is a better way - this feels crazy,
			// but I am new to R - this should create a boxplot
			for (int i = 0; i < frequency; i++) {
				int logNfiles = nFiles == 0 ? 0
						: (int) Math.ceil(Math.log(nFiles));
				if (firstNumber) {
					sb.append("" + logNfiles);
					firstNumber = false;
				} else {
					sb.append(", " + logNfiles);
				}
			}
		}
		sb.append(")\n");
		System.out.println(sb.toString());
		return sb.toString();
	}

	private static void populateTexDatabase(
			HashMap<String, Integer> databaseFileContent,
			String connectionString) throws ClassNotFoundException,
			SQLException, ValueMissingException {
		//
		// first get the total number of projects observed
		String valueName = "nObserved";
		String query = "SELECT frequency as " + valueName +
			" FROM FilesPerProjectMerged WHERE nFiles = -1;";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));

		//
		// get the total number of observed projects that could not be
		// classified as Python or not
		valueName = "nSkipped";
		query = "SELECT frequency as " + valueName +
			" FROM FilesPerProjectMerged WHERE nFiles = -2;";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));

		//
		// get the total number of Python Projects that the scraper tried to
		// clone and scrape but failed on
		valueName = "nAborted";
		query = "SELECT frequency as " + valueName +
			" FROM FilesPerProjectMerged WHERE nFiles = -3;";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));

		//
		// get the total number of projects scanned successfully
		valueName = "nScanned";
		query = "SELECT SUM(frequency) as " +
			valueName +
			" FROM FilesPerProjectMerged WHERE nFiles != -1 AND nFiles != -2 AND nFiles != -3;";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));

		//
		// get the total number projects where at least one Regex was found
		valueName = "nProjectsWithRegex";
		query = "SELECT COUNT(*) as " +
			valueName +
			" FROM (SELECT uniqueSourceID FROM RegexCitationMerged GROUP BY uniqueSourceID);";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));

		//
		// get the total number of python files scanned, regex or no
		valueName = "nPythonFiles";
		query = "SELECT SUM(product) AS " +
			valueName +
			" FROM (SELECT nFiles, frequency, (nFiles * frequency) AS product FROM FilesPerProjectMerged);";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));

		//
		// get the total number python files with at least one regex usage found
		valueName = "nFilesWithRegex";
		query = "SELECT COUNT(*) as " + valueName +
			" FROM (SELECT DISTINCT uniqueSourceID, filePath FROM RegexCitationMerged);";
		databaseFileContent.put(valueName, getIntFromQuery(connectionString, query, valueName));
	}

	private static String stringifyMap(HashMap<String, Integer> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("key,value\n");
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> e : entrySet) {
			sb.append(e.getKey());
			sb.append(",");
			sb.append(e.getValue().toString() + "\n");
		}
		return sb.toString();
	}

	private static int getIntFromQuery(String connectionString, String query,
			String valueName) throws ClassNotFoundException, SQLException,
			ValueMissingException {
		int value = Integer.MIN_VALUE;

		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(connectionString);
		c.setAutoCommit(false);
		stmt = c.createStatement();

		// execute query, look for the valueName
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			value = rs.getInt(valueName);
			System.out.println(valueName + ": " + value);
		} else {
			System.out.println("No value for: " + valueName);
		}

		// wind down sql
		rs.close();
		stmt.close();
		c.close();

		// fail fast for missing values
		if (value == Integer.MIN_VALUE) {
			throw new ValueMissingException();
		}
		return value;
	}
}

class ValueMissingException extends Exception {
	private static final long serialVersionUID = 12345L;
}
