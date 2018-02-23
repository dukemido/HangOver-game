import java.util.Random;

public class Game implements IHangMan {

	static Random rnd = new Random();
	String solvedWord = "";
	GameKeyword baseKeyword;
	int wrongs = 0, maxWrongs;

	@Override
	public String selectRandomWord() {
		baseKeyword = GameKeyword.words.get(rnd.nextInt(GameKeyword.words.size()));
		for (int i = 0; i < baseKeyword.getKeyword().length(); i++)
			solvedWord += "-";
		return solvedWord;
	}

	@Override
	public String guess(char c) {
		if (wrongs == maxWrongs) {
			System.out.println("GAME OVER!");
			return "hung_s";
		}
		if (solvedWord.indexOf(c) != -1)// the character is found already.
			System.out.println("This character is already found!");
		else if (baseKeyword.getKeyword().indexOf(c) == -1)// wrong guess
		{
			wrongs++;
			System.out.println("Wrong guess!");
		} else {
			for (int i = 0; i < baseKeyword.getKeyword().length(); i++) {
				String current = baseKeyword.getKeyword();
				if (current.charAt(i) == c) {
					StringBuilder myName = new StringBuilder(solvedWord);
					myName.setCharAt(i, current.charAt(i));
					solvedWord = myName.toString();
				}
			}
		}
		if (solvedWord.indexOf("-") == -1)
			return "won_s";
		return solvedWord;
	}

	@Override
	public void setMaxWrongs(int max) {
		this.maxWrongs = max;

	}

	public void printInfo() {
		if (solvedWord.indexOf("-") == -1)
			System.out.println("YOU WON!");
		else
			System.out.println("Word: " + solvedWord + "\tClue:" + baseKeyword.getInformation() + "\nLeft Trials:"
					+ (maxWrongs - wrongs) + "\n\tWrong:" + wrongs + "\n");
	}

}
