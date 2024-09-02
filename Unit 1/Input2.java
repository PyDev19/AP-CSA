//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - takes last name and first name input and prints them

import java.util.Scanner;

public class Input2 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("First Name: ");
		String first_name = scanner.nextLine();

		System.out.print("Last Name: ");
		String last_name = scanner.nextLine();

		System.out.println("");
		System.out.println("####################");
		System.out.println("####################");
		System.out.println(first_name + " " + last_name);
		System.out.println("####################");
		System.out.println("####################");
		System.out.println(last_name + " " + first_name);
		System.out.println("####################");
		System.out.println("####################");

		scanner.close();
	}
}