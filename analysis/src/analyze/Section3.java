package analyze;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class Section3 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) {

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {

		return "";
	}


	public static void main(String[] args) {
		ArrayList<WeightRankedRegex> corpus = new ArrayList<WeightRankedRegex>();
		corpus.add(new WeightRankedRegex("'ab*c(pute+r)[^xzq]\\1'", 24));
		corpus.add(new WeightRankedRegex("'\\d{3}[-. ]\\d{3}[-. ]\\d{4}'", 80));
		corpus.add(new WeightRankedRegex("'\\d\\d\\d[-. ]\\d\\d\\d[-. ]\\d\\d\\d\\d'", 100));
		corpus.add(new WeightRankedRegex("'\\d\\d'", 4));
		HalfMatrix x = getJaroWinklerSimilarityMatrix(corpus);
		System.out.println(x);
	}


}
