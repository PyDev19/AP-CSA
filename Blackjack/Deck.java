//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates a deck of cards and shuffles them. It also has methods to access the deck and get the next card.

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static final int NUMFACES = 13;
    public static final int NUMSUITS = 4;
    public static final int NUMCARDS = 52;

    public static final String SUITS[] = { "CLUBS", "SPADES", "DIAMONDS", "HEARTS" };

    private int topCardIndex;
    private ArrayList<BlackJackCard> stackOfCards;

    public Deck() {
        // initialize data - stackOfCards - topCardIndex
        stackOfCards = new ArrayList<BlackJackCard>();
        topCardIndex = NUMCARDS - 1;

        for (int i = 0; i < NUMSUITS; i++) {
            for (int j = 1; j <= NUMFACES; j++) {
                stackOfCards.add(new BlackJackCard(j, SUITS[i]));
            }
        }

    }

    // modifiers
    public void shuffle() {
        Collections.shuffle(stackOfCards);
        topCardIndex = NUMCARDS - 1;
    }

    // accessors
    public int size() {
        return stackOfCards.size();
    }

    public int numCardsLeft() {
        return topCardIndex + 1;
    }

    public BlackJackCard nextCard() {
        return stackOfCards.get(topCardIndex--);
    }

    public String toString() {
        return stackOfCards + "   topCardIndex = " + topCardIndex;
    }
}