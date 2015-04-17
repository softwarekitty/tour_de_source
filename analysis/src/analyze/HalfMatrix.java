package analyze;

import java.text.DecimalFormat;
import java.util.Random;

//for a symetric similarity matrix that takes half the space
public class HalfMatrix {
	private double[][] values;
	
	public HalfMatrix(int n){
		values = new double[n][];
		for(int i=0;i<n;i++){
			values[i] = new double[i];
			for(int j=0;j<i;j++){
				values[i][j] = 1.0;
			}
		}
	}
	
	//row is i, col is j
	//so triangle is in lower left
	public double get(int row, int col){
		if(row==col){
			return 1;
		}else if(row<col){
			return values[col][row];
		}else{
			return values[row][col];
		}
	}
	
	//row is i, col is j
	//so triangle is in lower left
	public void set(int row, int col, double d){
		if(row==col){
			return;
		}
		if(row<col){
			values[col][row] = d;
		}else{
			values[row][col] = d;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.00");
		sb.append("Matrix:\n");
		for(double[] A : values){
			sb.append("[");
			for(double d : A){
				sb.append(df.format(d)+" ");
			}
			sb.append("]\n");
		}
		return sb.toString();
	}
	
	//testing the Half-Matrix
	public static void main(String[] args){
		Random gen = new Random();

		HalfMatrix x = new HalfMatrix(5);
		System.out.println(x.toString());
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				x.set(i, j, gen.nextDouble());
			}
		}
		System.out.println(x.toString());
		System.out.println("with symetry:");
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i=0;i<5;i++){
			System.out.print("[");
			for(int j=0;j<5;j++){
				System.out.print(df.format(x.get(i, j))+" ");
			}
			System.out.println("]");
		}
	}
	
	

}
