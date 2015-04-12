package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C {

	public static String N_PROJ_SCANNED = "nScanned";
	public static String N_PROJ_HAS_REGEX = "nProjectsWithRegex";
	public static String N_PYTHON_FILES = "nPythonFiles";
	public static String N_FILES_HAS_REGEX = "nFilesWithRegex";
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

	public static String HAS_FLAGS = "HAS_FLAGS";
	public static String CANNOT_PARSE = "CANNOT_PARSE";
	public static String CAN_PARSE = "CAN_PARSE";

	public static String HAS_ALIEN = "HAS_ALIEN";
	public static String DISTINCT_PATTERN = "DISTINCT_PATTERN";
	public static String N_RC = "N_RC";

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
