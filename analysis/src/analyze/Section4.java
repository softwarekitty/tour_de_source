package analyze;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mifmif.common.regex.Generex;

public class Section4 {

	static void contributeToMap(HashMap<String, String> databaseFileContent,
			String connectionString) {

	}

	static String contributeRString(
			HashMap<String, String> databaseFileContent,
			String connectionString, String homePath)
			throws ClassNotFoundException, SQLException {

		return "";
	}
	
	// here is an example of why we are faced with a difficult choice.
	// the genrex package doesn't support backreferences (among others)
	// and generating random strings is exponential-time
	public static void main(String[] args) {
		int nMatches = 100;
		Set<String> matches = new TreeSet<String>();
		int counter = 0;
		int i = 0;
		int minLength = 3;
		int maxLength = 64;

		String regex = "a(b+)cde[^arx]\\1";
		Generex generex = new Generex(regex);
		// com.mifmif.common.regex.util.Iterator iterator = generex.iterator();

		Random gen = new Random();
		// String regex = "\\\\(.)";

		Pattern p = Pattern.compile(regex);
		char[] charsToUse = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9', '`', '~', '!', '@', '#', '$', '%', '^',
				'&', '*', '(', ')', '-', '_', '+', '=', '{', '[', '}', ']',
				'|', '\\', ':', ';', '"', '\'', '<', ',', '>', '.', '?', '/' };
		while (matches.size() < nMatches && counter < Integer.MAX_VALUE / 256) {
			// String genS =
			// RandomStringUtils.random(gen.nextInt(1+maxLength-minLength)+minLength,
			// charsToUse);
			String genS = generex.random();

			//genS = RandomStringUtils.random(gen.nextInt(1 + maxLength -minLength) + minLength, charsToUse);

			Matcher m = p.matcher(genS);
			while (m.find()) {
				matches.add(m.group());
			}
			if (counter++ % 100000 == 0) {
				System.out.println("i: " + i + " generated string: " + genS);
				i++;
			}

		}
		System.out.print("\n\nmatches: ");
		for (String s : matches) {
			System.out.print(s + "•");
		}
	}


}
