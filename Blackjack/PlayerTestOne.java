//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to test the Player class. It creates a player object and a deck object, shuffles the deck, adds two cards to the player's hand, prints the player object, prints the value of the player's hand, adds two more cards to the player's hand, prints the player object, and prints the value of the player's hand.

import static java.lang.System.*;

public class PlayerTestOne {
    public static void main(String args[]) {
        Player player = new Player();

        Deck deck = new Deck();
        deck.shuffle();

        player.addCardToHand(deck.nextCard());
        player.addCardToHand(deck.nextCard());

        out.println("\n\ntoString");
        out.println(player);

        out.println("\n\nhandValue");
        out.println(player.getHandValue());

        player.addCardToHand(deck.nextCard());
        player.addCardToHand(deck.nextCard());

        out.println("\n\ntoString");
        out.println(player);

        out.println("\n\nhandValue");
        out.println(player.getHandValue());
    }
}