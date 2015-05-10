package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import analyze.exceptions.ValueMissingException;

public class C {
	
	//for string similarity switch
	public static final int COS = 0;
	public static final int JACC = 1;
	public static final int JAROW = 2;
	public static final int LEV = 3;
	public static final int LCS = 4;
	public static final int SFT = 5;
	public static final String[] functionames = { "cos", "jacc", "jaroW", "lev", "lcs", "sift" };
	
	//for slides and color charts
	public static final String N_ALIEN = "N_ALIEN";	
	public static final String N_UNICODE = "N_UNICODE";
	public static final String N_PCRE_ERROR = "N_PCRE_ERROR";
	public static final String P_LITERAL_PRESENT ="P_LITERAL_PRESENT";
	public static final String R_SCRIPTNAME = "analysis_script.r";
	public static final String P_LITERAL_TOKENS = "P_LITERAL_TOKENS";
	public static final String S3_SCRIPTNAME = "syntaxClusterInput.abc";
	public static final String S3_OUTPUT = "syntaxClusterOutput.abc";
	public static final String P_BAD_FLAGS = "percentBadFlags";
	public static final String P_INVALID_PATTERN = "percentInvalidPattern";
	public static final String P_CLEAN_USAGES = "percentCleanUsages";
	public static final String P_UNICODE = "percentUnicode";
	public static final String N_PROJECTS_USING_REGEX = "nProjectsUsingRegex";
	public static final String N_FILES_USING_REGEX = "nFilesUsingRegex";

	//Study.RECORDING REGEX USAGES
	public static String N_CLONE_URL = "nCloneURL";
	public static String N_ABORTED = "nAborted";
	public static String N_PROJ_SCANNED = "nProjScanned";
	public static String N_USAGES = "nUsages";
	
	//Study.FILTERING REGEX USAGES
	public static String N_BAD_FLAGS = "nBadFlags";
	public static String N_INVALID_PATTERN = "nInvalidPattern";
	public static String N_CLEAN_USAGES = "nCleanUsages";
	public static String N_DISTINCT_PATTERNS= "nDistinctPatterns";
	public static String P_PCRE_ERROR = "percentPCREError";
	public static String P_ALIEN = "percentAlien";
	public static String N_CORPUS = "nCorpus";
	
	//Results.CONTEXT AND CORPUS ORIGIN
	public static String P_PROJECTS_USING_REGEX = "percentProjectsUsingRegex";
	public static String P_FILES_USING_REGEX = "percentFilesUsingRegex";
	
	//for context quantile table
	public static String Q1_RFILE_PER_PROJECT = "q1RFilePerProj";
	public static String Q1_FILE_PER_PROJECT = "q1FilePerProj";
	public static String Q1_R_PER_FILE = "q1RPerFile";
	
	public static String MED_RFILE_PER_PROJECT = "medRFilePerProj";
	public static String MED_FILE_PER_PROJECT = "medFilePerProj";
	public static String MED_R_PER_FILE = "medRPerFile";
	
	public static String Q3_RFILE_PER_PROJECT = "q3RFilePerProj";
	public static String Q3_FILE_PER_PROJECT = "q3FilePerProj";
	public static String Q3_R_PER_FILE = "q3RPerFile";
	
	public static String MAX_RFILE_PER_PROJECT = "maxRFilePerProj";
	public static String MAX_FILE_PER_PROJECT = "maxFilePerProj";
	public static String MAX_R_PER_FILE = "maxRPerFile";
	
	public static String N_EXPECTED_USAGES = "nExpectedUsages";
	
	//Restuls.FUNCTIONS AND FLAGS
	public static String P_COMPILE = "percentCompile";
	public static String P_FLAGS_0 = "percentFlags0";
	public static String P_IGNORECASE = "percentI";
	public static String P_MULTILINE = "percentM";

	
	
	
	//public static String N_PROJ_HAS_REGEX = "nProjectsWithRegex";
	//public static String N_PYTHON_FILES = "nPythonFiles";
	//public static String N_FILES_HAS_REGEX = "nFilesWithRegex";
	public static String FUNC_0 = "FUNC_0";
	public static String FUNC_1 = "FUNC_1";
	public static String FUNC_2 = "FUNC_2";
	public static String FUNC_3 = "FUNC_3";
	public static String FUNC_4 = "FUNC_4";
	public static String FUNC_5 = "FUNC_5";
	public static String FUNC_6 = "FUNC_6";
	public static String FUNC_7 = "FUNC_7";

	public static String FLAGS_0 = "FLAGS_0";
	public static String FLAGS_2 = "FLAGS_2";
	public static String FLAGS_4 = "FLAGS_4";
	public static String FLAGS_8 = "FLAGS_8";
	public static String FLAGS_16 = "FLAGS_16";
	public static String FLAGS_32 = "FLAGS_32";
	public static String FLAGS_64 = "FLAGS_64";
	public static String FLAGS_128 = "FLAGS_128";
	public static String FLAGS_255 = "FLAGS_128";
	
	


	public static int getIntFromQuery(String connectionString, String query,
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
