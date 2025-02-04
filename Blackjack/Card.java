//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a card object with a face and suit. It also has a method to compare two cards and a method to print the card.

public class Card {
    public static final String FACES[] = { "ACE", "TWO", "THREE", "FOUR",
            "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING" };

    private String suit;
    private int face;

    // constructors
    public Card() {
        suit = "";
        face = 0;
    }

    public Card(int f, String s) {
        face = f;
        suit = s;
    }

    // modifiers
    public void setFace(int f) {
        face = f;
    }

    public void setSuit(String s) {
        suit = s;
    }

    // accessors
    public String getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    public boolean equals(Object obj) {
        Card other = (Card) obj;
        return suit.equals(other.getSuit()) && face == other.getFace();
    }

    public String toString() {
        return FACES[face-1] + " of " + suit + " | value = " + (face >= 10 ? 10 : face);
    }
}