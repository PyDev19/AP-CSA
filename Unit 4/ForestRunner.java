//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to run the forest and test it out.

import java.io.IOException;
import java.util.Scanner;

public class ForestRunner {
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.print("Enter the number of columns: ");
		int cols = scanner.nextInt();

		Forest woods = new Forest(rows, cols);
		System.out.println(woods + "\n\n");
		System.out.println(woods.setTrappedToNull() + "\n\n");
		System.out.println(woods + "\n\n");

		scanner.close();
	}
}
