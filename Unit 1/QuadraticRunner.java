//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - takes a, b, and c input and prints the roots of the quadratic equation

import java.util.Scanner;

public class QuadraticRunner {
	public static void main(String[] args) {
		//use a Scanner for keyboard input
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a :: ");
		int a = scanner.nextInt();

		System.out.print("Enter b :: ");
		int b = scanner.nextInt();

		System.out.print("Enter c :: ");
		int c = scanner.nextInt();

		double root_one = Quadratic.getRootOne(a, b, c);
		double root_two = Quadratic.getRootTwo(a, b, c);

		System.out.println("\n\nroot one :: " + String.format("%.2f", root_one));
		System.out.println("root two :: " + String.format("%.2f", root_two));
		
		//add test cases

		scanner.close();
	}
}