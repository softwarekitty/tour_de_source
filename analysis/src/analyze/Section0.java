package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.python.util.PythonInterpreter;

import analyze.exceptions.ValueMissingException;

public class Section0 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) throws ClassNotFoundException,
			SQLException, ValueMissingException {

		// TODO - put this into the db from the scraper
		// get the total number of clone urls that we got from GHTorrent
		String valueName = C.N_CLONE_URL;
		String query = "SELECT frequency as " + valueName +
			" FROM FilesPerProjectMerged WHERE nFiles = -1;";
		databaseFileContent.put(valueName, Composer.commafy(C.getIntFromQuery(connectionString, query, valueName)));

		//
		// get the total number of Python Projects that the scraper tried to
		// clone and scrape but failed on
		valueName = C.N_ABORTED;
		query = "SELECT frequency as " + valueName +
			" FROM FilesPerProjectMerged WHERE nFiles = -2;";
		databaseFileContent.put(valueName, Composer.commafy(C.getIntFromQuery(connectionString, query, valueName)));

		//
		// get the total number of projects scanned successfully
		valueName = C.N_PROJ_SCANNED;
		query = "SELECT SUM(frequency) as " +
			valueName +
			" FROM FilesPerProjectMerged WHERE nFiles != -1 AND nFiles != -2 AND nFiles != -3;";
		databaseFileContent.put(valueName, Composer.commafy(C.getIntFromQuery(connectionString, query, valueName)));

		//
		// 0.V5 total number of unique re.* usages observed
		valueName = C.N_USAGES;
		query = "SELECT COUNT(*) as " + valueName +
			" FROM RegexCitationMerged;";
		databaseFileContent.put(valueName, Composer.commafy(C.getIntFromQuery(connectionString, query, valueName)));

		//
		// 0.V8.0 - count of usages where flags=0 or arg#, which will default to
		// 0
		valueName = C.FLAGS_0;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where flags=0 or flags like 'arg%';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V8.128 - count of usages where flags=128
		valueName = C.FLAGS_128;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where flags=128 or flags='re.DEBUG';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.2 - count of usages where flags=2
		valueName = C.FLAGS_2;
		query = "select count(*) as " +
			valueName +
			" from RegexCitationMerged where flags=2 or flags='re.I' or flags='re.IGNORECASE';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.4 - count of usages where flags=4
		valueName = C.FLAGS_4;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where flags=4 or flags='re.L' or flags='re.LOCALE';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.8 - count of usages where flags=8
		valueName = C.FLAGS_8;
		query = "select count(*) as " +
			valueName +
			" from RegexCitationMerged where flags=8 or flags='re.M' or flags='re.MULTILINE';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.16 - count of usages where flags=16
		valueName = C.FLAGS_16;
		query = "select count(*) as " +
			valueName +
			" from RegexCitationMerged where flags=16 or flags='re.S' or flags='re.DOTALL';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.32 - count of usages where flags=32
		valueName = C.FLAGS_32;
		query = "select count(*) as " +
			valueName +
			" from RegexCitationMerged where flags=32 or flags='re.U' or flags='re.UNICODE';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.64 - count of usages where flags=64
		valueName = C.FLAGS_64;
		query = "select count(*) as " +
			valueName +
			" from RegexCitationMerged where flags=64 or flags='re.X' or flags='re.VERBOSE';";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V9.255 - count of usages of composed flags - these are very rare or
		// non-existent but possible. Note that like does not have character
		// classes.
		valueName = C.FLAGS_255;
		query = "select count(*) as " +
			valueName +
			" from RegexCitationMerged where (flags like '0%' or flags like '1%' or flags like '2%' or flags like '3%' or flags like '4%' or flags like '5%' or flags like '6%' or flags like '7%' or flags like '8%' or flags like '9%') and (flags not in (0,2,4,8,16,32,64,128))";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));
		// note that there are other, possibly invalid entries in this column
		// like 'None' or a myConst.flag1 - we will ignore these and they are
		// rare.

		// 0.V9 this is a count of all behavioral flags
		int nBadFlags = Composer.intify(databaseFileContent.get(C.FLAGS_2)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_4)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_8)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_16)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_32)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_64)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_255));

		int nUsages = Composer.intify(databaseFileContent.get(C.N_USAGES));
		databaseFileContent.put(C.N_BAD_FLAGS, Composer.commafy(nBadFlags));
		databaseFileContent.put(C.P_BAD_FLAGS, Composer.percentify(nBadFlags, nUsages));

		//
		// count how many flagless regex usages have patterns that python can
		// parse
		int[] nInvalid = { 0 };
		int[] nClean = { 0 };
		getNFlaglessInvalidClean(connectionString, nInvalid, nClean);
		databaseFileContent.put(C.N_CLEAN_USAGES, Composer.commafy(nClean[0]));
		databaseFileContent.put(C.N_INVALID_PATTERN, Composer.commafy(nInvalid[0]));
		databaseFileContent.put(C.P_INVALID_PATTERN, Composer.percentify(nInvalid[0],nUsages));
		databaseFileContent.put(C.P_CLEAN_USAGES, Composer.percentify(nClean[0],nUsages));

		// Results.CONTEXT.SATURATION
		int nProjScanned = Composer.intify(databaseFileContent.get(C.N_PROJ_SCANNED));
		int nProjWithRegex = C.getIntFromQuery(connectionString, "SELECT COUNT(*) as PwR FROM (SELECT uniqueSourceID FROM RegexCitationMerged GROUP BY uniqueSourceID);", "PwR");
		int nFilesWithRegex = C.getIntFromQuery(connectionString, "SELECT COUNT(*) as FwR FROM (SELECT DISTINCT uniqueSourceID, filePath FROM RegexCitationMerged);", "FwR");
		int nFilesScanned = C.getIntFromQuery(connectionString, "SELECT SUM(product) AS nF FROM (SELECT nFiles, frequency, (nFiles * frequency) AS product FROM FilesPerProjectMerged);", "nF");
		String percentProjectsUsingRegex = Composer.percentify(nProjWithRegex, nProjScanned);
		databaseFileContent.put(C.P_PROJECTS_USING_REGEX, percentProjectsUsingRegex);
		String percentFilesUsingRegex = Composer.percentify(nFilesWithRegex, nFilesScanned);
		databaseFileContent.put(C.P_FILES_USING_REGEX, percentFilesUsingRegex);
		String nProjectsUsingRegex = Composer.commafy(nProjWithRegex);
		databaseFileContent.put(C.N_PROJECTS_USING_REGEX, nProjectsUsingRegex);
		String nFilesUsingRegex = Composer.commafy(nFilesWithRegex);
		databaseFileContent.put(C.N_FILES_USING_REGEX, nFilesUsingRegex);



		// Results.FUNCTIONS AND FLAGS
		// note: the regexFunction mapping uses indices from this array:
		// ["re.compile", "re.search", "re.match", "re.split", "re.findall",
		// "re.finditer", "re.sub", "re.subn"]

		//
		// 0.V6.0 - count of usages where regexFunction=0
		valueName = C.FUNC_0;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=0;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.1 - count of usages where regexFunction=1
		valueName = C.FUNC_1;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=1;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.2 - count of usages where regexFunction=2
		valueName = C.FUNC_2;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=2;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.3 - count of usages where regexFunction=3
		valueName = C.FUNC_3;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=3;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.4 - count of usages where regexFunction=4
		valueName = C.FUNC_4;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=4;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.5 - count of usages where regexFunction=5
		valueName = C.FUNC_5;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=5;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.6 - count of usages where regexFunction=6
		valueName = C.FUNC_6;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=6;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		//
		// 0.V6.7 - count of usages where regexFunction=7
		valueName = C.FUNC_7;
		query = "select count(*) as " + valueName +
			" from RegexCitationMerged where regexFunction=7;";
		databaseFileContent.put(valueName, "" +
			C.getIntFromQuery(connectionString, query, valueName));

		// C.P_COMPILE
		int nCompile = Composer.intify(databaseFileContent.get(C.FUNC_0));
		String percentCompile = Composer.percentify(nCompile, nUsages);
		databaseFileContent.put(C.P_COMPILE, percentCompile);

		// C.P_FLAGS_0
		int nDefaultOrDebug = Composer.intify(databaseFileContent.get(C.FLAGS_0)) +
			Composer.intify(databaseFileContent.get(C.FLAGS_128));
		String percentFlags0 = Composer.percentify(nDefaultOrDebug, nUsages);
		databaseFileContent.put(C.P_FLAGS_0, percentFlags0);

		// C.P_IGNORECASE, C.P_MULTILINE
		int nIgnoreCase = Composer.intify(databaseFileContent.get(C.FLAGS_2));
		int nMultiline = Composer.intify(databaseFileContent.get(C.FLAGS_8));
		String percentIgnorecase = Composer.percentify(nIgnoreCase, nBadFlags);
		String percentMultiline = Composer.percentify(nMultiline, nBadFlags);
		databaseFileContent.put(C.P_IGNORECASE, percentIgnorecase);
		databaseFileContent.put(C.P_MULTILINE, percentMultiline);
	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {

		StringBuilder rScriptContent = new StringBuilder();
		rScriptContent.append("\n");

		// 0.P3 how regexFunction partitions observed usages
		int f0 = Composer.intify(databaseFileContent.get(C.FUNC_0));
		int f1 = Composer.intify(databaseFileContent.get(C.FUNC_1));
		int f2 = Composer.intify(databaseFileContent.get(C.FUNC_2));
		int f3 = Composer.intify(databaseFileContent.get(C.FUNC_3));
		int f4 = Composer.intify(databaseFileContent.get(C.FUNC_4));
		int f5 = Composer.intify(databaseFileContent.get(C.FUNC_5));
		int f6 = Composer.intify(databaseFileContent.get(C.FUNC_6));
		int f7 = Composer.intify(databaseFileContent.get(C.FUNC_7));
		int[] data_P0_3 = { f0, f1, f2, f3, f4, f5, f6, f7 };
		String[] labels_P0_3 = { "re.compile", "re.search", "re.match",
				"re.split", "re.findall", "re.finditer", "re.sub", "re.subn" };
		String[] colors_P0_3 = { "gray50", "gray30", "gray75", "gray12",
				"gray87", "gray20", "gray67", "gray8" };
		rScriptContent.append(Composer.composeBarplotFromData(data_P0_3, labels_P0_3, homePath, "partFunctions", 5, 2.1, colors_P0_3));

		// 0.P4 observed valid flags
		int flag2 = Composer.intify(databaseFileContent.get(C.FLAGS_2));
		int flag4 = Composer.intify(databaseFileContent.get(C.FLAGS_4));
		int flag8 = Composer.intify(databaseFileContent.get(C.FLAGS_8));
		int flag16 = Composer.intify(databaseFileContent.get(C.FLAGS_16));
		int flag32 = Composer.intify(databaseFileContent.get(C.FLAGS_32));
		int flag64 = Composer.intify(databaseFileContent.get(C.FLAGS_64));
		int flag255 = Composer.intify(databaseFileContent.get(C.FLAGS_255));

		int[] data_P0_4 = { flag2, flag4, flag8, flag16, flag32, flag64,
				flag255 };
		String[] labels_P0_4 = { "IGNORECASE", "LOCALE", "MULTILINE", "DOTALL",
				"UNICODE", "VERBOSE", "multiple flags" };
		String[] colors_P0_4 = { "gray80", "gray32", "gray67", "gray8",
				"gray50", "gray92", "grey20" };
		rScriptContent.append(Composer.composeBarplotFromData(data_P0_4, labels_P0_4, homePath, "partFlags", 5, 2.1, colors_P0_4));

		return rScriptContent.toString();
	}

	/**
	 * it's a little inefficient, but straightforward and organized
	 */
	private static void getNFlaglessInvalidClean(String connectionString,
			int[] invalidCounter, int[] cleanCounter) throws SQLException,
			ClassNotFoundException {
		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(connectionString);
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String query = "select pattern from RegexCitationMerged where flags=0 or flags like 'arg%' or flags=128 or flags='re.DEBUG';";

		// these are all the regexes without behavioral flags
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String pattern = rs.getString("pattern");
			try {
				if (pattern == null) {
					throw new IllegalArgumentException("pattern cannot be null");
				} else if ("".equals(pattern)) {
					throw new IllegalArgumentException("pattern cannot be empty");
				} else {
					// make sure the pattern is a valid regex
					PythonInterpreter interpreter = new PythonInterpreter();
					interpreter.exec("import re");
					interpreter.exec("x = re.compile(" + pattern + ")");
					//System.out.println("valid python pattern: "+pattern);
					cleanCounter[0]++;
				}
			} catch (Exception e) {
				//System.out.println("Section0.getNFlaglessInvalidClean: Cannot parse " + pattern + " because: " +e.getMessage());
				invalidCounter[0]++;
			}
		}

		// wind down sql
		rs.close();
		stmt.close();
		c.close();
	}

	private static DescriptiveStatistics statsFromListQuery(
			String connectionString, String query, String varName)
			throws ClassNotFoundException, SQLException {
		// Get a DescriptiveStatistics instance
		DescriptiveStatistics stats = new DescriptiveStatistics();

		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(connectionString);
		c.setAutoCommit(false);
		stmt = c.createStatement();

		// the query needs to return a relation,
		// with ints fetchable from varName
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			stats.addValue(rs.getInt(varName));
		}

		// wind down sql
		rs.close();
		stmt.close();
		c.close();
		return stats;
	}

	private static DescriptiveStatistics statsFilesPerProject(
			String connectionString) throws ClassNotFoundException,
			SQLException {
		// Get a DescriptiveStatistics instance
		DescriptiveStatistics stats = new DescriptiveStatistics();

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
		for (Entry<Integer, Integer> entry : filesPerProjectMap.entrySet()) {
			int nFiles = entry.getKey();
			int frequency = entry.getValue();
			for (int i = 0; i < frequency; i++) {
				stats.addValue(nFiles);
			}
		}
		return stats;
	}
	//filesPerProject,rFilesPerProject, regexPerFile
	public static Iterator<NamedStats> getContextStatsAndAddToDatabase(String connectionString, HashMap<String, String> databaseFileContent) throws ClassNotFoundException, SQLException {
		int nProjScanned = Composer.intify(databaseFileContent.get(C.N_PROJ_SCANNED));

		List<NamedStats> nsList = new LinkedList<NamedStats>();
		DescriptiveStatistics filesPerProjectStats = statsFilesPerProject(connectionString);
		DescriptiveStatistics rFilesPerProjectStats = statsFromListQuery(connectionString, "select distinct uniqueSourceID, filePath, count(distinct filePath) as ct from RegexCitationMerged group by uniqueSourceID;", "ct");
		DescriptiveStatistics regexPerFileStats = statsFromListQuery(connectionString, "select count(filePath) as ct from RegexCitationMerged group by uniqueSourceID, filePath;", "ct");
		nsList.add(new NamedStats("files per project",filesPerProjectStats));
		nsList.add(new NamedStats("files with regex per project",rFilesPerProjectStats));
		nsList.add(new NamedStats("regex utilizations per file",regexPerFileStats));
		
		databaseFileContent.put(C.Q1_RFILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			rFilesPerProjectStats.getPercentile(25))));
		databaseFileContent.put(C.Q1_FILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			filesPerProjectStats.getPercentile(25))));
		databaseFileContent.put(C.Q1_R_PER_FILE, Composer.commafy(Composer.intify("" +
			regexPerFileStats.getPercentile(25))));

		databaseFileContent.put(C.MED_RFILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			rFilesPerProjectStats.getPercentile(50))));
		databaseFileContent.put(C.MED_FILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			filesPerProjectStats.getPercentile(50))));
		databaseFileContent.put(C.MED_R_PER_FILE, Composer.commafy(Composer.intify("" +
			regexPerFileStats.getPercentile(50))));

		databaseFileContent.put(C.Q3_RFILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			rFilesPerProjectStats.getPercentile(75))));
		databaseFileContent.put(C.Q3_FILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			filesPerProjectStats.getPercentile(75))));
		databaseFileContent.put(C.Q3_R_PER_FILE, Composer.commafy(Composer.intify("" +
			regexPerFileStats.getPercentile(75))));

		databaseFileContent.put(C.MAX_RFILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			rFilesPerProjectStats.getMax())));
		databaseFileContent.put(C.MAX_FILE_PER_PROJECT, Composer.commafy(Composer.intify("" +
			filesPerProjectStats.getMax())));
		databaseFileContent.put(C.MAX_R_PER_FILE, Composer.commafy(Composer.intify("" +
			regexPerFileStats.getMax())));

		double nExpectedUsages = regexPerFileStats.getPercentile(50) *
			filesPerProjectStats.getPercentile(50) * nProjScanned;

		databaseFileContent.put(C.N_EXPECTED_USAGES, Composer.commafy(Composer.intify("" +
			Composer.round(nExpectedUsages, 0))));
		return nsList.iterator();
	}

}
