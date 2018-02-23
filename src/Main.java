import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("words.txt");

			BufferedReader buffReader = new BufferedReader(reader);
			String l = null, all = "";

			while ((l = buffReader.readLine()) != null)
				all += l + "#"; // Read all and put in l

			String[] elements = all.split("#");

			for (String p : elements) {
				String[] w_info = p.split("-");

				// Create the word and adds it to the List
				new GameKeyword(w_info[0], w_info[1]);
			}
			System.out.println("Loaded " + GameKeyword.words.size() + " words in memory.");
			// Print game rules.

			System.out.println(
					"Game rules:\n1.You have n-trials [you'll be promoted to set it (10 by default)] to guess the word.\n"
							+ "2.The information will be provided with the game.\n"
							+ "Choose what you want from the menu.");
			int max_wrong = 10;
			while (true) {
				System.out.println("1.Start new game.\n2.Set max trials.");
				Scanner in = new Scanner(System.in);
				switch (in.nextInt()) {
				case 1: {
					Game game = new Game();
					game.setMaxWrongs(max_wrong);
					game.selectRandomWord();
					while (true) {
						game.printInfo();
						char g = in.next().charAt(0);// My guess char.
						clearScreen();
						String q = game.guess(g);
						if (q == "won_s") {
							System.out.println("You won the game!");
							break;
						}
						if(q == "hung_s") {
							System.out.println("The man hunged himself, YOU LOST!");
							break;
						}
						System.out.println(q);
					}
					break;
				}

				case 2: {
					System.out.println("Enter the max number of trials.");
					max_wrong = in.nextInt();
					System.out.println("Max trials is " + max_wrong);
					break;
				}

				}
			}

			// GameKeyword.printAll();

		} catch (FileNotFoundException ex) {
			System.out.println("Can't find the words file.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearScreen() {
		for (int i = 0; i < 100; i++)
			System.out.println("\b");

	}
}
