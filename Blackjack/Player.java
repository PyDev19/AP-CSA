//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a player object that can be used in the BlackJack game. It has methods to add cards to the player's hand, reset the player's hand, set and get the player's win count, get the size of the player's hand, get the value of the player's hand, check if the player should hit, and return a string representation of the player object. The player object has an ArrayList of BlackJackCard objects and an integer winCount.

import java.util.*;

public class Player {
    private ArrayList<BlackJackCard> hand;
    private int winCount;

    public Player() {
        hand = new ArrayList<BlackJackCard>();
        winCount = 0;
    }

    public Player(int score) {
        hand = new ArrayList<BlackJackCard>();
        winCount = score;
    }

    public void addCardToHand(BlackJackCard temp) {
        hand.add(temp);
    }

    public void resetHand() {
        hand.clear();
    }

    public void setWinCount(int numwins) {
        winCount = numwins;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getHandValue() {
        int value = 0;
        for (BlackJackCard c : hand) {
            value += c.getValue();
        }

        return value;
    }

    public boolean hit() {
        return getHandValue() < 17;
    }

    public String toString() {
        return "hand = " + hand.toString() + " - " + getHandValue();
    }
}