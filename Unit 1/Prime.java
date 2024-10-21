//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Prime class to check if a number is prime or not and print the result to the console

public class Prime {
	private int number;

	// constructor methods go here
	public Prime(int n) {
		number = n;
	}

	public void setPrime(int num) {
		number = num;
	}

	// boolean isPrime() goes here
	public boolean isPrime() {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		if (isPrime()) {
			return number + " IS PRIME.";
		} else {
			return number + " IS NOT PRIME.";
		}
	}
}