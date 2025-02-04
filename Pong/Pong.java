//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class contains the main methods to draw the pong game and handle the logic for the key events, ball and paddle movements, and collision detection.

import java.awt.*;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

public class Pong extends Canvas implements KeyListener, Runnable {
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;
    private int scoreRight;
    private int scoreLeft;

    public Pong() {
        // set up all variables related to the game
        keys = new boolean[4];
        setBackground(Color.WHITE);

        Random rng = new Random();

        Color col;
        col = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
        ball = new Ball(rng.nextInt(400) + 1, rng.nextInt(300) + 1, rng.nextInt(5) + 10, rng.nextInt(5) + 10, col,
                rng.nextInt(7) + 1, rng.nextInt(1) + 1);

        Color colo = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
        leftPaddle = new Paddle(50, 300, 10, 40, colo, 5);

        colo = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
        rightPaddle = new Paddle(750, 300, 10, 40, colo, 5);

        setVisible(true);
        new Thread(this).start();
        addKeyListener(this); // starts the key thread to log key stroke

    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        Graphics graphToBack = back.createGraphics();

        // Move and draw ball
        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        // Clear previous score area
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(10, 0, 100, 50); // Adjusted area to remove artifacts

        // Draw updated scores
        graphToBack.setColor(Color.RED);
        graphToBack.drawString("Left Score : " + scoreLeft, 10, 10);
        graphToBack.drawString("Right Score: " + scoreRight, 10, 30);

        if (ball.getX() <= 0) { // Left wall
            scoreRight++;
            resetBall(graphToBack);
        }

        if (ball.getX() >= getWidth() - ball.getWidth()) { // Right wall
            scoreLeft++;
            resetBall(graphToBack);
        }

        // Ball bouncing on the top/bottom walls
        if (ball.getY() <= 0 || ball.getY() >= getHeight() - ball.getHeight()) {
            ball.setYSpeed(-ball.getYSpeed());
        }

        // Collision with left paddle
        if ((ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() &&
                ball.getY() + ball.getHeight() >= leftPaddle.getY() &&
                ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight())) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        // Collision with right paddle
        if ((ball.getX() + ball.getWidth() >= rightPaddle.getX() &&
                ball.getY() + ball.getHeight() >= rightPaddle.getY() &&
                ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight())) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        // Paddle movement
        if (keys[0])
            leftPaddle.moveUpAndDraw(graphToBack);
        if (keys[1])
            leftPaddle.moveDownAndDraw(graphToBack);
        if (keys[2])
            rightPaddle.moveUpAndDraw(graphToBack);
        if (keys[3])
            rightPaddle.moveDownAndDraw(graphToBack);

        // Draw everything to screen
        twoDGraph.drawImage(back, null, 0, 0);
    }

    // Reset ball to center with new random direction
    private void resetBall(Graphics graphToBack) {
        // Erase the old ball
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

        // Reset ball position to center
        ball.setX(getWidth() / 2);
        ball.setY(getHeight() / 2);

        // Give ball a new random speed and direction
        Random rand = new Random();
        ball.setXSpeed((rand.nextBoolean() ? 1 : -1) * (rand.nextInt(3) + 2));
        ball.setYSpeed((rand.nextBoolean() ? 1 : -1) * (rand.nextInt(3) + 2));
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'S':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'K':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'S':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'K':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread();
                Thread.sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
