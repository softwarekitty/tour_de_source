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
			SQLException, ValueMissingException, IOException {
		//
		// initialize
		System.out.println("begin paper writer");
		HashMap<String, Integer> databaseFileContent = new HashMap<String, Integer>();
		String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/";
		String connectionString = "jdbc:sqlite:" + homePath +
			"tools/merged/merged_report.db";

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

		// draw boxplot/beeswarm of # unique python files in a project's
		// history using R
		String scriptName = "analysis_script.r";
		String databaseName = "database.csv";
		String outputPath = homePath + "analysis/analysis_output/";
		FileUtils.cleanDirectory(new File(outputPath));

		IOUtil.createAndWrite(new File(outputPath + databaseName), stringifyMap(databaseFileContent));
		System.out.println("Operation done successfully");

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
