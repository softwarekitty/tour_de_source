package analyze;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import org.rosuda.JRI.Rengine;
//import org.rosuda.JRI.REXP;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class PaperWriter {

	public static void main(String[] args) {
		System.out.println("begin paper writer");
		HashMap<String,Integer> databaseFileContent = new HashMap<String,Integer>();
		
		String homePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/";
//		Rengine rengine = new Rengine();
//		rengine.eval(String.format("greeting <- '%s'", "Hello R World"));
//		REXP result = rengine.eval("greeting");
//		System.out.println("Greeting from R: "+result.asString());
//		
		
// c.execute('''CREATE TABLE RegexCitation (uniqueSourceID int, sourceJSON text, fileHash char(44), filePath text, pattern text, flags int, regexFunction int)''')
// c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:"+homePath+"tools/merged/merged_report.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	      stmt = c.createStatement();
	      
	      //first get the total number of projects observed
	      ResultSet rs = stmt.executeQuery( "SELECT frequency as observed FROM FilesPerProjectMerged WHERE nFiles = -1;" );
	      if(rs.next()){
		      int nProjectsObserved = rs.getInt("observed");
		      System.out.println("nProjectsObserved: " + nProjectsObserved); 
		      databaseFileContent.put("nProjectsObserved", nProjectsObserved);
	      }else{
		      System.out.println("No value for: " + "nProjectsObserved");  
	      }
	      rs.close();
	      
	      //get the total number of observed projects that could not be classified as Python or not
	      rs = stmt.executeQuery( "SELECT frequency as RRfailures FROM FilesPerProjectMerged WHERE nFiles = -2;" );
	      if(rs.next()){
		      int nRefreshRepoFailures = rs.getInt("RRfailures");
		      System.out.println("nRefreshRepoFailures: " + nRefreshRepoFailures);
		      databaseFileContent.put("nRefreshRepoFailures", nRefreshRepoFailures);
	      }else{
		      System.out.println("No value for: " + "RRfailures");  
	      }
	      rs.close();
	      
	      //get the total number of Python Projects that the scraper tried to clone and scrape but failed on
	      rs = stmt.executeQuery( "SELECT frequency as GRfailures FROM FilesPerProjectMerged WHERE nFiles = -3;" );
	      if(rs.next()){
		      int nGetRewinderFailures = rs.getInt("GRfailures");
		      System.out.println("nGetRewinderFailures: " + nGetRewinderFailures);
		      databaseFileContent.put("nGetRewinderFailures", nGetRewinderFailures);
	      }else{
		      System.out.println("No value for: " + "GRfailures");  
	      }
	      rs.close();
	      
	      //get the total number of projects scanned successfully
	      rs = stmt.executeQuery( "SELECT SUM(frequency) as frequencySum FROM FilesPerProjectMerged WHERE nFiles != -1 AND nFiles != -2 AND nFiles != -3;" );
	      if(rs.next()){
		      int nPythonProjects = rs.getInt("frequencySum");
		      System.out.println("nPythonProjects: " + nPythonProjects);
		      databaseFileContent.put("nPythonProjects", nPythonProjects);
	      }else{
		      System.out.println("No value for: " + "frequencySum");  
	      }
	      rs.close();
	      
	      //get the total number of projects where at least one regex was found
	      rs = stmt.executeQuery( "SELECT COUNT(*) as nProjectsWithRegex FROM (SELECT uniqueSourceID FROM RegexCitationMerged GROUP BY uniqueSourceID);" );
	      if(rs.next()){
		      int nProjectsWithRegex = rs.getInt("nProjectsWithRegex");
		      System.out.println("nProjectsWithRegex: " + nProjectsWithRegex);
		      databaseFileContent.put("nProjectsWithRegex", nProjectsWithRegex);
	      }else{
		      System.out.println("No value for: " + "nProjectsWithRegex");  
	      }
	      rs.close();
	      
	      //get the total number python files scanned
	      rs = stmt.executeQuery( "SELECT SUM(product) AS nFilesScanned FROM (SELECT nFiles, frequency, (nFiles * frequency) AS product FROM FilesPerProjectMerged);" );
	      if(rs.next()){
		      int nFilesScanned = rs.getInt("nFilesScanned");
		      System.out.println("nFilesScanned: " + nFilesScanned);
		      databaseFileContent.put("nFilesScanned", nFilesScanned);
	      }else{
		      System.out.println("No value for: " + "nFilesScanned");  
	      }
	      rs.close();
	      
	      //get the total number python files with at least one regex usage found
	      rs = stmt.executeQuery( "SELECT COUNT(*) as nFilesWithRegex FROM (SELECT DISTINCT uniqueSourceID, filePath FROM RegexCitationMerged);" );
	      if(rs.next()){
		      int nFilesWithRegex = rs.getInt("nFilesWithRegex");
		      System.out.println("nFilesWithRegex: " + nFilesWithRegex); 
		      databaseFileContent.put("nFilesWithRegex", nFilesWithRegex);
	      }else{
		      System.out.println("No value for: " + "nFilesWithRegex");  
	      }
	      rs.close();
	     
	      //draw boxplot/beeswarm of # unique python files in a project's history using R
	      String scriptName = "analysis_script.r";
	      String databaseName = "database.csv";
	      String outputPath = homePath + "analysis/analysis_output/";
	      FileUtils.cleanDirectory(new File(outputPath));
	      
	      
	      IOUtil.createAndWrite(new File(outputPath + databaseName), stringifyMap(databaseFileContent));
	      stmt.close();
	      c.close();
	      
	      
	    } catch ( Exception e ) {
	    	e.printStackTrace();
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");

	}
	
	private static String stringifyMap(
			HashMap<String, Integer> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("key,value\n");
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> e : entrySet){
			sb.append(e.getKey());
			sb.append(",");
			sb.append(e.getValue().toString() + "\n");
		}
		return sb.toString();
	}

	private static void createBoxPlotBeeswarm(){
		
	}

}


