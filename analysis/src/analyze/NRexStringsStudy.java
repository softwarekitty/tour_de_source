package analyze;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.inference.TTest;

public class NRexStringsStudy {

	public static void main(String[] args) throws IOException {
		final String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/csharp/nRexStringsStudy/";
		double[][][] data = new double[3][4][];
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				String nStrings = "" + ((j+1)*100);
				String suffix = "sample_" + i + "/" + nStrings + "/column.txt";
				String columnPath = homePath + suffix;
				List<String> lines = FileUtils.readLines(new File(columnPath));
				double[] col = new double[lines.size()];
				int m = 0;
				for(String line : lines){
					col[m++] = Double.parseDouble(line);
				}
				data[i][j] = col;
			}
		}
		double[][] answers = new double[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				TTest tester = new TTest();
				answers[i][j] = tester.tTest(data[i][j], data[i][j+1]);
			}
		}
		System.out.println("answers: " + Arrays.deepToString(answers));
	}

}
