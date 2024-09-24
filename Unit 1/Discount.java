//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Discount class that checks if the discount is valid and returns the bill amount.

public class Discount {
	private double amount;

	public Discount(double a) {
		amount = a;
	}

	public boolean check() {
		return amount > 2000;
	}

	public double getTheBill() {
		if (check()) {
			return amount * 0.85;
		} else {
			return amount;
		}
	}
}