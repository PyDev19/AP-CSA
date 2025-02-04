//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class defines a subclass of the Card class, it is used to create a card object that is used in the blackjack game

public class BlackJackCard extends Card {
    public BlackJackCard() {
        super();
    }

    public BlackJackCard(int f, String s) {
        super(f, s);
    }

    public int getValue() {
        if (getFace() == 1) {
            return 11;
        } else if (getFace() >= 10) {
            return 10;
        } else {
            return getFace();
        }
    }
}