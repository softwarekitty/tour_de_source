package analyze;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.inference.TTest;
import org.apache.commons.math3.stat.inference.MannWhitneyUTest;

public class NRexStringsStudy {

	public static void main(String[] args) throws IOException {
		final String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/csharp/nRexStringsStudy/";
		double[][][] data = new double[3][9][];
		for(int i=0;i<3;i++){
			for(int j=0;j<9;j++){
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
		double[][] answers = new double[3][8];
		for(int i=0;i<3;i++){
			if(i==1)
				continue;
			for(int j=0;j<8;j++){
				TTest tester = new TTest();
				MannWhitneyUTest mannW = new MannWhitneyUTest();
				answers[i][j] = tester.pairedTTest(data[i][j], data[i][j+1]);
				//System.out.println("i: " + i + " j: " + j + " tTest: " + tester.tTest(data[i][j], data[i][j+1],0.05));
				System.out.println("i: " + i + " j: " + j + " mannWhitneyU: " + mannW.mannWhitneyU(data[i][j], data[i][j+1]));
			}
		}
		System.out.println("answers: " + Arrays.deepToString(answers));
	}

}
