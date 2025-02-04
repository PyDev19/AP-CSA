//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to test the paddle class visually by drawing it on a canvas and moving it up and down

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable {
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;

    public PaddleTestTwo() {
        keys = new boolean[5];

        ball = new Ball(100, 100, 10, 10, Color.BLACK, 2, 1);

        leftPaddle = new Paddle(10, 10, 10, 10, Color.BLACK, 2);

        rightPaddle = new Paddle(770, 10, 10, 10, Color.BLACK, 2);

        keys = new boolean[5];

        setBackground(Color.WHITE);
        setVisible(true);

        this.addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        ball.moveAndDraw(window);
        leftPaddle.draw(window);
        rightPaddle.draw(window);

        if (!(ball.getX() >= 10 && ball.getX() <= 550)) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= 450)) {
            ball.setYSpeed(-ball.getYSpeed());
        }

        if (keys[0] == true) {
            // move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(window);
        }
        if (keys[1] == true) {
            // move left paddle down and draw it on the window
            leftPaddle.moveDownAndDraw(window);
        }
        if (keys[2] == true) {
            // move right paddle up and draw it on the window
            rightPaddle.moveUpAndDraw(window);
        }
        if (keys[3] == true) {
            // move right paddle down and draw it on the window
            rightPaddle.moveDownAndDraw(window);
        }
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
        // no code needed here
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