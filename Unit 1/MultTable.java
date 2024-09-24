//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class defines the multiplication table and its methods, including the printTable method.

public class MultTable {
	private int number;
	private int stop;

	public MultTable(int n, int s) {
		number = n;
		stop = s;
	}

	public void printTable() {
		for (int i = 1; i <= stop; i++) {
			System.out.printf("%d\t%d\n", i, i * number);
		}
	}
}