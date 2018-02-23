import java.util.ArrayList;

public class GameKeyword {

	public static ArrayList<GameKeyword> words = new ArrayList<GameKeyword>();
	private String keyword; // The helping information about the word.
	String information;

	public GameKeyword(String keyword, String information) {
		this.keyword = keyword;
		this.information = information;
		words.add(this);
	}

	public static void printAll() {
		for (int i = 0; i < words.size(); i++) {
			GameKeyword w = (GameKeyword) words.get(i);
			System.out.println("Keyword: " + w.getKeyword() + " Info: " + w.getInformation());
		}
	}
	
	public String getKeyword() {
		return keyword;
	}

	public String getInformation() {
		return information;
	}

}
