//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Black jack card class to assign values to the regular card class by inheriting it

public class BlackJackCard extends Card {
	private int value;

	public BlackJackCard(String suit, int face) {
		super(suit, face);

		if (face == 0 || ( face >= 2 && face <= 10) ) {
			value = face;
		} else {
			value = face == 1 ? 11 : 10;
		}
	}
	
	public int getValue() {
		return value;
	}

	public String toString() {
		return FACES[face] + " of " + suit + " " + value;
	}
}
