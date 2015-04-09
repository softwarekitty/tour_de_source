package basicScraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AstroidWorker implements Runnable {
	private String pythonBin = null;
	private String scanOnePath = null;
	private String baseFolder = null;
	private int repoID;
	private String dbPath = null;

	public AstroidWorker(String pythonBin, String scanOnePath,
			String baseFolder, int repoID, String dbPath) {
		this.pythonBin = pythonBin;
		this.scanOnePath = scanOnePath;
		this.baseFolder = baseFolder;
		this.repoID = repoID;
		this.dbPath = dbPath;
	}

	@Override
	public void run() {
		Process p = null;
		try {
			String[] processArgs = { pythonBin, scanOnePath, baseFolder,
					"" + repoID, dbPath };
			String line;
			p = Runtime.getRuntime().exec(processArgs);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			System.out.println("Waiting for Astroid ...");
			try {
				if (p != null) {
					if(!p.waitFor(20, TimeUnit.MINUTES)){
						System.out.println("WARNING: Process timed out after 20 minutes on " + repoID);
						p.destroyForcibly();
					}
				}
			} catch (InterruptedException e) {
				System.out.println("Process Interrupted...");
				e.printStackTrace();
			}
			System.out.println("Astroid finished " + repoID);
		} catch (IOException e) {

			System.out.println("Failure to lanuch process...");
			e.printStackTrace();
		}
	}

	// "/Users/carlchapman/Documents/SoftwareProjects/tempRepos/"
	// test the AstroidWorker
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		final ExecutorService exService = Executors.newFixedThreadPool(8);
		
		//Note: need to git pull these first, because they rewind every time.
		AstroidWorker aW1 = new AstroidWorker("/usr/bin/python", "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/scanOnePath.py", "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/repo", 33379020, "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/data/onePathTest.db");
		AstroidWorker aW2 = new AstroidWorker("/usr/bin/python", "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/scanOnePath.py", "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/repo", 33379021, "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/data/onePathTest.db");
		exService.submit(aW1);
		exService.submit(aW2);
		exService.shutdown();
		try {
			exService.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("Process Interrupted...");
			System.exit(0);
		}
	}

}
