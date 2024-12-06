//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class to generate the fibonacci sequence

public class Fibonacci {
	// instance variable
	private int size;
	private int[] sequence;

	// constructors
	public Fibonacci(int s) {
		size = s;
		sequence = new int[size];
		generateFib();
	}

	// set method
	public void setFib(int s) {
		size = s;
		sequence = new int[size];
		generateFib();
	}

	// get method
	public int getFib(int s) {
		if (s < 0 || s >= size) {
			return -1;
		}
		return sequence[s];
	}

	public void generateFib() {
		if (size == 0) {
			return;
		}
		sequence[0] = 0;
		sequence[1] = 1;
		sequence[2] = 1;
		for (int i = 3; i < size; i++) {
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		}
	}

	// toString
	public String toString() {
		String output = "";
		
		for (int num : sequence) {
			output += num + " ";
		}

		return output;
	}
}