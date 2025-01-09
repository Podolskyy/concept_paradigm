import java.util.*;

public class Main {

	public static void main(String[] args) {
		int userInput = 0;
		Scanner input = new Scanner(System.in);
		GameFactory gameFactory = new GameFactory();

		do {
			System.out.println("Which game would you like to play?"
					+ "\n1. PowerBall "
					+ "\n2. MegaMillion"
					+ "\n3. HotLotto"
					+ "\n4. Exit");
			userInput = input.nextInt();

			Game game = gameFactory.createGame(userInput);
			if (game != null) {
				game.play();
			} else if (userInput != 4) {
				System.out.println("Please choose a valid number between 1 and 4!");
			}
		} while (userInput != 4);
	}
}

// Factory class to handle game creation
class GameFactory {
	public Game createGame(int gameType) {
		switch (gameType) {
			case 1:
				return new Powerball();
			case 2:
				return new MegaMillion();
			case 3:
				return new HotLotto();
			default:
				return null;
		}
	}
}
