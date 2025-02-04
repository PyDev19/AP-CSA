//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This is the class where the blackjack game is run, it handles the player input and the logic of the game

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack {
    private Player player;
    private Dealer dealer;

    public BlackJack() {
        player = new Player();
        dealer = new Dealer();
    }

    public void playGame() {
        Scanner keyboard = new Scanner(System.in);
        char choice;

        while (true) {
            dealer.shuffle(); // Ensure new hands are different
            player.resetHand();
            dealer.resetHand();

            // Initial dealing
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());

            out.println("PLAYER ");
            out.println(player);
            out.println();

            // Player turn
            while (true) {
                out.println("Do you want to hit? (y/n) ");
                choice = keyboard.next().charAt(0);

                if (choice == 'y') {
                    player.addCardToHand(dealer.deal());
                    out.println("PLAYER ");
                    out.println(player);
                    out.println();
                    
                    if (player.getHandValue() > 21) {
                        out.println("PLAYER BUSTS! DEALER WINS.");
                        out.println("DEALER ");
                        out.println(dealer);
                        break;
                    }
                } else {
                    break;
                }
            }

            if (player.getHandValue() <= 21) {
                // Dealer turn (hits until reaching 17)
                while (dealer.getHandValue() < 17) {
                    dealer.addCardToHand(dealer.deal());
                }

                out.println("DEALER ");
                out.println(dealer);
                out.println();

                // Determine winner
                if (dealer.getHandValue() > 21) {
                    out.println("DEALER BUSTS! PLAYER WINS.");
                } else if (player.getHandValue() > dealer.getHandValue()) {
                    out.println("PLAYER WINS.");
                } else if (player.getHandValue() == dealer.getHandValue()) {
                    out.println("TIE.");
                } else {
                    out.println("DEALER WINS.");
                }
            }

            // Ask to play again
            out.println("Do you want to play again? (y/n) ");
            choice = keyboard.next().charAt(0);
            if (choice == 'n') {
                break;
            }
        }

        keyboard.close();
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.playGame();
    }
}
