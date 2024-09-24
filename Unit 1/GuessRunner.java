//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This program runs the guessing game and asks the user if they want to play again.

import java.util.Scanner;
import static java.lang.System.*;

public class GuessRunner {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			out.print("Guessing Game - How many numbers? ");
			int stop = keyboard.nextInt();

			GuessingGame game = new GuessingGame(stop, keyboard);
			game.playGame();
			System.out.println(game);

			keyboard.nextLine();

			out.println();
			out.print("Do you want to play again? ");
			String response = keyboard.nextLine();

			if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("y")) {
				break;
			}
		}

		keyboard.close();
	}
}