package basicScraper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Scraper {

	private static String baseFolder = "/Users/carlchapman/Documents/SoftwareProjects/tempRepos/";

	public static void main(String[] args) throws InterruptedException, IOException, JSONException {
		System.out.println(getRepoList());
		System.exit(0);

		// TODO - just make from scratch with own blocking queue, not getting
		// size.
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(16);
		final ThreadPoolExecutor exService = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, workQueue);

		//
		List<RepoReference> repoList = getRepoList();
		for (RepoReference repo : repoList) {
			// create a directory for the repo
			File f = new File(baseFolder + "/" + repo.getRepoID());
			if (f.exists()) {

				// really shouldn't ever get here if we just emptied the
				// directory
				System.out.println("Repository exists.\nDeleting repository and cloning a new copy....");
				try {
					FileUtils.deleteDirectory(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			f.mkdir();

			// clone this repo to folder
			String remotePath = repo.getCloneUrl();
			try {
				Git.cloneRepository().setURI(remotePath).setDirectory(f).call();
				System.out.println("Cloned project " + repo.getName() +
					" into: " + f.getAbsolutePath());
				AstroidWorker aW = new AstroidWorker("/usr/bin/python", "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/scanOnePath.py", "/Users/carlchapman/Documents/SoftwareProjects/tempRepos",  repo.getRepoID(), "/Users/carlchapman/Documents/SoftwareProjects/tempRepos/onePathTest.db");
				while(true){
					try{
						exService.submit(aW);
						break;
					}catch(RejectedExecutionException ree){
						System.out.println("worker for "+ repo.getRepoID() + " was rejected");
					}
					Thread.sleep(1500);
				}
				System.out.println("submitted worker for " + repo.getRepoID());
			} catch (GitAPIException e) {
				System.out.println("ERROR cloning " + repo.getCloneUrl() +
					" into: " + f.getAbsolutePath());
				e.printStackTrace();
			}

			// empty the repo's folder
			try {
				FileUtils.deleteDirectory(f);
			} catch (IOException e) {
				System.err.println("could not clean file: " +
					f.getAbsolutePath() + " EXCEPTION: " + e.getStackTrace());
			}
		}

		try {
			exService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			System.out.println("Scraping complete!");
		} catch (InterruptedException e) {
			System.out.println("Process Interrupted...");
			System.exit(0);
		}
	}

	private static List<RepoReference> getRepoList() throws IOException, JSONException {
		List<RepoReference> repoList = new LinkedList<RepoReference>();
		String testPath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/tools/output";
		String fileContents = FileUtils.readFileToString(new File(testPath));
		final JSONObject obj = new JSONObject(fileContents);
	    final JSONArray list = obj.getJSONArray("list");
	    
	    for(int i=0;i<list.length();i++){
	    	JSONObject o = list.getJSONObject(i);
	    	repoList.add(new RepoReference(o.getInt("id"), o.getString("clone_url"),o.getString("name")));//, o.getString("languages_url")
	    }
		return repoList;
	}
}
