//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class tests the Deck class by creating a deck object and then printing out the cards in the deck, the number of cards left in the deck, shuffling the deck, and then printing out the deck again.

import static java.lang.System.*;

public class DeckTestOne {
    public static void main(String args[]) {
        Deck deck = new Deck();
        for (int i = 0; i < Deck.NUMCARDS; i++) {
            out.println(deck.nextCard());
        }

        out.println("\n\n");

        out.println("num cards left in the deck == " + deck.numCardsLeft());

        out.println("\n\nshuffling");
        deck.shuffle();
        out.println("num cards left in the deck == " + deck.numCardsLeft());

        out.println("\n\ntoString");
        out.println(deck);
    }
}