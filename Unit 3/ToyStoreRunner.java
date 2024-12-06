// (c) A+ Computer Science
// www.apluscompsci.com
// Name - Atharva Mishra
// Class - Patterson 3B
// Description - Class that creates a toy store object with a list of toys that can be accessed and modified

public class ToyStoreRunner {
	public static void main(String args[]) {
		ToyStore sto = new ToyStore();
		System.out.println(sto);
		String[] s = "sorry bat sorry sorry sorry train train teddy teddy ball ball".split(" ");
		sto.loadToys(s);
		System.out.println(sto);
		System.out.println("max == " + sto.getMostFrequentToy());
		System.out.println(sto.getThatToy("sorry"));
	}
}