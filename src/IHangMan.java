
public interface IHangMan {

	String selectRandomWord();
	String guess(char c);
	void setMaxWrongs(int max);
}
