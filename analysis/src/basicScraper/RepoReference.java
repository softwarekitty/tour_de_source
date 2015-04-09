package basicScraper;

public class RepoReference {
	
	private int repoID;
	private String cloneURL;
	private String name;
	
	public RepoReference(int repoID, String cloneURL, String name){
		this.repoID=repoID;
		this.cloneURL = cloneURL;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "RepoReference [repoID=" + repoID + ", name=" + name + "]";
	}

	public int getRepoID(){
		return this.repoID;
	}
	
	public String getCloneUrl(){
		return this.cloneURL;
	}
	
	public String getName(){
		return this.name;
	}

}
