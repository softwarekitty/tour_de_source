package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Cluster extends TreeSet<WeightRankedRegex> implements RankableContent{
	
	private int topN;
	private TreeSet<Integer> projectIDs;
	
	public Cluster(int topN){
		super();
		this.topN = topN;
		projectIDs = new TreeSet<Integer>();
	}
	
	@Override
	public boolean add(WeightRankedRegex x){
		return super.add(x);
	}

	@Override
	public int getRankableValue() {
		return projectIDs.size();
	}
	
	public TreeSet<Integer> getProjectIDs(){
		return projectIDs;
	}
	
	public void initialzeNProjects() throws ClassNotFoundException, SQLException{
		TreeSet<Integer> projectIDSet = new TreeSet<Integer>();
		Iterator<WeightRankedRegex> it = iterator();
		while(it.hasNext()){
			WeightRankedRegex wrr = it.next();
			ArrayList<Integer> projectIDs = getProjectIDsHavingPattern(wrr.getContent());
			projectIDSet.addAll(projectIDs);
		}
		this.projectIDs = projectIDSet;
	}
	
	
	public static ArrayList<Integer> getProjectIDsHavingPattern(String pattern)
			throws SQLException, ClassNotFoundException {
		ArrayList<Integer> projectIDList = new ArrayList<Integer>(32);

		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(PaperWriter.connectionString);
		c.setAutoCommit(false);
		
		PreparedStatement ps = c.prepareStatement("select uniqueSourceID as ID from RegexCitationMerged where pattern=?");
		ps.setString(1, pattern);

		// the query needs to return a relation,
		// the first string is a key, second the pattern
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			projectIDList.add(ID);
		}

		// wind down sql
		rs.close();
		c.close();
		return projectIDList;
	}

	@Override
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRankedRegex> it = this.iterator();
		int i=0;
		if(it.hasNext()){
			WeightRankedRegex x = it.next();
			sb.append(x.getContent()+"::"+x.getRankableValue());
			i++;
		}
		while(it.hasNext() && i<topN){
			WeightRankedRegex x = it.next();
			sb.append(",");
			sb.append(x.getContent()+"::"+x.getRankableValue());
			i++;
		}
		return sb.toString();
	}
	
	public String getShortest(){
		Iterator<WeightRankedRegex> it = this.iterator();
		String smallest = null;
		if(it.hasNext()){
			
			//should always get here - no empty clusters
			smallest = it.next().getUnescapedPattern();
		}
		while(it.hasNext()){
			String smaller = it.next().getUnescapedPattern();
			if(smaller.length() < smallest.length()){
				smallest = smaller;
			}
		}
		return smallest;
	}

	@Override
	public int compareTo(RankableContent other) {
		if(other.getClass()!=this.getClass()){
			System.err.println("class mismatch");
			return 1;
		}
		Cluster cOther = (Cluster)other;
		int nProjectsThis = this.getRankableValue();
		int nProjectsOther = cOther.getRankableValue();
		//higher weight is earlier
		if(nProjectsThis > nProjectsOther){
			return -1;
		}else if(nProjectsThis < nProjectsOther){
			return 1;
		}else{
			String myContent = this.getContent();
			String otherContent = cOther.getContent();
			//shorter length is earlier
			if(myContent.length() > otherContent.length()){
				return 1;
			}else if(myContent.length() < otherContent.length()){
				return -1;
			}else{
				
				//same weight and length: by hashcode
				return myContent.compareTo(otherContent);
			}
		}
	}
}
