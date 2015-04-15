package analyze;

public class NameContentsPair {
	private final String filename;
	private final String contents;

	public NameContentsPair(String filename, String contents) {
		this.filename = filename;
		this.contents = contents;
	}

	public String getFilename() {
		return filename;
	}

	public String getContents() {
		return contents;
	}

}
