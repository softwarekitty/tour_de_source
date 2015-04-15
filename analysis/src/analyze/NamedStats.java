package analyze;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class NamedStats {

	private final String name;
	private final DescriptiveStatistics stats;

	public NamedStats(String name, DescriptiveStatistics stats) {
		this.name = name;
		this.stats = stats;
	}

	public String getName() {
		return name;
	}

	public DescriptiveStatistics getStats() {
		return stats;
	}

}
