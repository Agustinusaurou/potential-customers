public class ImportantWord {
	private String importance;
	private String word;

	public ImportantWord(String importance, String word) {
		super();
		this.importance = importance;
		if (word != null) {
			this.word = word;
		}
	}

	public String getImportance() {
		return importance;
	}

	public String getWord() {
		return word;
	}
}
