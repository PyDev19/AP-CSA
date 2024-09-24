//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class defines the guessing game and its methods, including the playGame method and the toString method.

import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGame {
	private int upperBound;
	private int lowerBound = 1;
	private Random random = new Random();
	private Scanner keyboard;
	private int count = 0;
	private int number = 0;
	private int percent_incorrect = 0;

	public GuessingGame(int stop, Scanner scanner) {
		upperBound = stop;
		keyboard = scanner;
	}

	public void playGame() {
		int number = random.nextInt(upperBound) + lowerBound;
		int guess = 0;
		int count = 0;

		int percent_parts = 100 / upperBound;

		while (guess != number) {
			out.print("Enter a number between 1 and " + upperBound + " : ");
			guess = keyboard.nextInt();

			if (guess < lowerBound || guess > upperBound) {
				out.println("Number out of range!");
			}

			if (guess != number) {
				percent_incorrect += percent_parts;
			}
			
			count++;
		}

		this.number = number;
		this.count = count;
	}

	public String toString() {
		String output = "";

		output += "It took you " + count + " guesses to guess " + number;
		output += "\nYou guessed wrong " + percent_incorrect + "% of the time";
		
		return output;
	}
}