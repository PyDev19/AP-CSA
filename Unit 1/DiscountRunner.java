//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Runner class that takes user input and returns the bill amount after discount.

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			out.print("Enter the original bill amount (enter quit to quit) :: ");
			String amount = keyboard.nextLine();
			
			if (amount.equals("quit")) {
				break;
			}

			Discount d = new Discount(Double.parseDouble(amount));
			out.printf("Bill after discount :: %.2f \n\n", d.getTheBill());
		}

		keyboard.close();
	}
}