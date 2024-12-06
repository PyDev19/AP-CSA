//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class runs the Fibonacci class and tests the methods in it.

import java.util.Scanner;

public class FibonacciRunner {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Fibonacci fib = new Fibonacci(0);

		while (true) {
			System.out.print("Enter size of sequence (0 to quit) :: ");
			int num = scanner.nextInt();
			fib.setFib(num);

			if (num == 0) {
				break;
			}
			
			while (true) {
				System.out.print("Enter position to get the number at (-1 to quit) :: ");
				int pos = scanner.nextInt();
				System.out.println(fib.getFib(pos));

				if (pos == -1) {
					break;
				}
			}
		}

		scanner.close();
	}
}