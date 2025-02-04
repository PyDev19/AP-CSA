//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This is the Dealer class which extends the Player class and has the functionality of a dealer in a BlackJack game. It has a deck of cards and can shuffle the deck, deal a card, check if it should hit or not and also check the number of cards left in the deck.

public class Dealer extends Player {
    private Deck deck;

    public Dealer() {
        deck = new Deck();
    }

    public void shuffle() {
        deck.shuffle();
    }

    public BlackJackCard deal() {
        return deck.nextCard();
    }

    public int numCardsLeftInDeck() {
        return deck.size();
    }

    public boolean hit() {
        return getHandValue() < 17;
    }
}
