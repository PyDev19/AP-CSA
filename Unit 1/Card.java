//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class to create Card objects and print their suit and face values

public class Card {
	public static final String FACES[] = { "ZERO", "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
			"NINE", "TEN", "JACK", "QUEEN", "KING" };

	String suit;
	int face;

	// constructors
	public Card(String suit, int face) {
		this.suit = suit;
		this.face = face;
	}

	// modifiers - mutators
	public void setFace(int face) {
		this.face = face;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	// accessors
	public String getSuit() {
		return suit;
	}

	public int getFace() {
		return face;
	}

	// toString
	public String toString() {
		return FACES[face] + " of " + suit;
	}
}