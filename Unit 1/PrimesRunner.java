//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class to run and test the prime class by creating Prime objects and printing whether the number is prime or not

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class PrimesRunner {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("primes.dat"));

		int size = file.nextInt();
		file.nextLine();

		for (int i = 0; i < size; i++) {
			Prime test = new Prime(file.nextInt());
			System.out.println(test);
		}

		file.close();
	}
}