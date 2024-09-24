//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Runner for StringStuff.java that tests the methods in the class by taking user input and displaying the results.

import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a word :: ");
		String word = keyboard.next();

		StringStuff test = new StringStuff(word);
		System.out.println("First and last letters :: " + test.getFirstLastLetters());
		System.out.println("Middle letter :: " + test.getMiddleLetter());
		System.out.println("First and last letters are the same :: " + test.sameFirstLastLetters());
		System.out.print("Enter a letter :: ");
		String letter = keyboard.next();
		System.out.println("Difference in ASCII values with letter " + letter + " :: " + test.diffInASCII(letter));
		
		keyboard.close();
	}
}