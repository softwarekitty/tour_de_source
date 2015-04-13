package analyze;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Composer {

	// for testing some of these little functions
	public static void main(String[] args) {
//		double x = 0.009978 / 1.0;
//		System.out.println(percentify(x, 1.0));
		int y=42000;
		System.out.println(commafy(y));
		System.out.println(intify(commafy(y)));

	}

	// public static String composeBarplotFromData(int[] data, String[] labels,
	// String homePath, String plotname, double width, double height) {
	// double[] doubleData = new double[data.length];
	// for (int i = 0; i < doubleData.length; i++) {
	// doubleData[i] = data[i] + 0.0;
	// }
	// return composeBarplotFromData(doubleData, labels, homePath, plotname,
	// width, height);
	// }

	//try width=5,height=2.1
	public static String composeBarplotFromData(int[] data, String[] labels,
			String homePath, String plotname, double width, double height,String[] colors) {
		// mostly following:
		// http://stackoverflow.com/questions/5142842
		int sum = 0;
		for(int d : data){
			sum+=d;
		}
		
		DecimalFormat df = new DecimalFormat("#0.#");
		// String[] dataS = stringifyNumbers(data);
		String widthS = df.format(width);
		String heightS = df.format(height);

		StringBuilder barplotContent = new StringBuilder();
		barplotContent.append("setEPS()\n");
		barplotContent.append("postscript(" +
			quote(homePath + "analysis/analysis_output/" + plotname + ".eps") +
			",width="+width+",height="+height+")\npar(mar=c(1,4,1,1), cex=0.97)\n");

		String matrixName = "M_" + plotname;
		barplotContent.append(matrixName + " = matrix(c(" +
			commaSeparate(stringifyNumbers(data)) + "),ncol=1,byrow=T)\n");
		barplotContent.append("rownames(" + matrixName + ")=c(" + "" +
			commaSeparate(composeRownames(labels, data)) + ")\n");

		barplotContent.append("barplot("+matrixName+",legend=rownames("+matrixName+"),col=c("+commaSeparate(composeColors(colors))+"),xlim=c(0,9),width=0.6,ylim = range(pretty(c(0, "+sum+"))),las=1)\n");
		barplotContent.append("dev.off()\n");
		return barplotContent.toString();
	}

	private static String[] composeColors(String[] colors) {
		int n = colors.length;
		String[] colorNames = new String[n];
		for (int i = 0; i < n; i++) {
			colorNames[i] = quote(colors[i]);
		}
		return colorNames;
	}

	private static String[] composeRownames(String[] labels, int[] data) {
		int n = labels.length;
		double sum = 0.0;
		for (double d : data) {
			sum += d;
		}
		String[] dataS = stringifyNumbers(data);
		String[] rowNames = new String[n];
		for (int i = 0; i < n; i++) {
			rowNames[i] = quote(labels[i] + " " + commafy(intify(dataS[i])) + " (" +
				percentify(data[i], sum) + "%)");
		}
		return rowNames;
	}

	public static String percentify(double d, double sum) {
		DecimalFormat df = new DecimalFormat("##0.#");
		return df.format(100 * round(d / sum, 3));
	}
	
	public static String commafy(int n) {
		return NumberFormat.getNumberInstance(Locale.US).format(n);
	}
	
	public static int intify(String s){
		int dotIndex = s.indexOf('.');
		String intString = s;
		if(dotIndex > -1){
			intString = s.substring(0,dotIndex);
		}
		return Integer.parseInt(intString.replaceAll(",", ""));
	}

	private static String quote(String s) {
		return "\"" + s + "\"";
	}

	private static String[] stringifyNumbers(int[] data) {
		String[] dataS = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			dataS[i] = ""+data[i];
		}
		return dataS;
	}

	private static String commaSeparate(String[] items) {
		if (items == null || items.length == 0) {
			return "";
		} else if (items.length == 1) {
			return items[0];
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(items[0]);
			for (int i = 1; i < items.length; i++) {
				sb.append(",");
				sb.append(items[i]);
			}
			return sb.toString();
		}
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
