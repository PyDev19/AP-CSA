//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to run the pong game and create the JFrame for the game.

import javax.swing.JFrame;
import java.awt.Component;

public class TheGame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public TheGame() {
        super("PONG");
        setSize(WIDTH, HEIGHT);

        Pong game = new Pong();

        ((Component) game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new TheGame();
    }
}