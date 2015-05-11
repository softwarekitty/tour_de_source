package analyze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import analyze.exceptions.PythonParsingException;
import analyze.exceptions.QuoteRuleException;
import metric.FeatureDictionary;

@SuppressWarnings("serial")
public class Cluster extends TreeSet<WeightRankedRegex> implements
		RankableContent {

	private int topN;
	private TreeSet<Integer> projectIDs;
	private FeaturePile featurePile = null;

	public Cluster(int topN) {
		super();
		this.topN = topN;
		projectIDs = new TreeSet<Integer>();
	}

	public void initialzeStats() throws ClassNotFoundException, SQLException {
		this.projectIDs = computeProjectIDs();
		this.featurePile = new FeaturePile(this);
	}

	@Override
	public boolean add(WeightRankedRegex x) {
		return super.add(x);
	}

	@Override
	public int getRankableValue() {
		return projectIDs.size();
	}

	public TreeSet<Integer> getProjectIDs() {
		return projectIDs;
	}

	public FeaturePile getFeaturePile() {
		return featurePile;
	}

	public boolean containsAnyFeatures(int[] featureGroup) {
		FeaturePile fp = this.getFeaturePile();
		for (int featureIndex : featureGroup) {
			if (fp.containsFeatureIndex(featureIndex)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAllFeatures(int[] featureGroup) {
		FeaturePile fp = this.getFeaturePile();

		// protect against false positives with error code
		if (featureGroup.length == 0) {
			return false;
		}
		boolean containsAll = true;
		for (int featureIndex : featureGroup) {
			containsAll = containsAll && fp.containsFeatureIndex(featureIndex);
		}
		return containsAll;
	}

	public TreeSet<Integer> computeProjectIDs() throws SQLException,
			ClassNotFoundException {
		StringBuilder querySB = new StringBuilder();

		// wow this is crazy, but should be faster than joining after the fact
		querySB.append("select distinct uniqueSourceID as ID from RegexCitationMerged where pattern=? ");
		int nPatterns = this.size();
		for (int i = 1; i < nPatterns; i++) {
			querySB.append("or pattern=? ");
		}
		querySB.append(";");

		TreeSet<Integer> projectIDList = new TreeSet<Integer>();

		// prepare sql
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection(PaperWriter.connectionString);
		c.setAutoCommit(false);

		PreparedStatement ps = c.prepareStatement(querySB.toString());
		int indexVal = 1;
		Iterator<WeightRankedRegex> it = this.iterator();
		while (it.hasNext()) {
			WeightRankedRegex wrr = it.next();
			ps.setString(indexVal++, wrr.getContent());
		}

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
		int i = 0;
		if (it.hasNext()) {
			WeightRankedRegex x = it.next();
			sb.append(x.getContent() + "::" + x.getRankableValue());
			i++;
		}
		while (it.hasNext() && i < topN) {
			WeightRankedRegex x = it.next();
			sb.append(",");
			sb.append(x.getContent() + "::" + x.getRankableValue());
			i++;
		}
		return sb.toString();
	}

	public String getShortest() {
		Iterator<WeightRankedRegex> it = this.iterator();
		String smallest = null;
		if (it.hasNext()) {

			// should always get here - no empty clusters
			smallest = it.next().getUnescapedPattern();
		}
		while (it.hasNext()) {
			String smaller = it.next().getUnescapedPattern();
			if (smaller.length() < smallest.length()) {
				smallest = smaller;
			}
		}
		return smallest;
	}

	public String getShortestWithFeature(int[] featureIndices) {
		Iterator<WeightRankedRegex> it = this.iterator();
		String smallest = "Cluster does not contain any of " +
			Arrays.toString(featureIndices) +
			" it does not contain them and so there cannot be any smallest feature containing at least one of them, also this string is really long so that it is very unlikely that the smallest regex containing one of those features would be larger than this one, although that is probably the most likely reason that you would see this string, as we shouldn't be calling this function without knowing ahead of time that the cluster does contain at least one of those features";
		while (it.hasNext()) {
			WeightRankedRegex wrr = it.next();
			boolean hasFeature = false;
			for(int fix : featureIndices){
				hasFeature = hasFeature || wrr.hasFeature(fix);
			}
			String pattern = wrr.getContent();
			if (hasFeature && pattern.length() < smallest.length()) {
				smallest = pattern;
			}
		}
		return smallest;
	}

	@Override
	public int compareTo(RankableContent other) {
		if (other.getClass() != this.getClass()) {
			System.err.println("class mismatch");
			return 1;
		}
		Cluster cOther = (Cluster) other;
		int nProjectsThis = this.getRankableValue();
		int nProjectsOther = cOther.getRankableValue();
		// higher weight is earlier
		if (nProjectsThis > nProjectsOther) {
			return -1;
		} else if (nProjectsThis < nProjectsOther) {
			return 1;
		} else {
			String myContent = this.getContent();
			String otherContent = cOther.getContent();
			// shorter length is earlier
			if (myContent.length() > otherContent.length()) {
				return 1;
			} else if (myContent.length() < otherContent.length()) {
				return -1;
			} else {

				// same weight and length: by hashcode
				return myContent.compareTo(otherContent);
			}
		}
	}
	
	//needed to count the number of projects supported by Rex, why not here?
	public static void main(String[] args) throws IllegalArgumentException, QuoteRuleException, PythonParsingException, ClassNotFoundException, SQLException{
		String filtered_corpus_path = PaperWriter.homePath +
				"csharp/filteredCorpus.txt";
		ArrayList<WeightRankedRegex> corpus = IOUtil.importCorpus( filtered_corpus_path);
		System.out.println("corpus size: "+corpus.size());
		Cluster allPatterns = new Cluster(Integer.MAX_VALUE);
		for(WeightRankedRegex wrr : corpus){
			allPatterns.add(wrr);
		}
		allPatterns.initialzeStats();
		System.out.println("total Projects Supported By Rex: "+allPatterns.getProjectIDs().size());

	}
}
