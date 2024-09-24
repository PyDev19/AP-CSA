//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This program runs the multiplication table and asks user for the number and stop number.

import java.util.Scanner;

public class MultTableRunner {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Multiplication table for: ");
		int number = keyboard.nextInt();

		System.out.print("How many multiples: ");
		int stop = keyboard.nextInt();

		MultTable table = new MultTable(number, stop);
		table.printTable();

		keyboard.close();
	}
}