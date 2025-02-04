//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to test the ball class visually on a canvas

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

class BallTestTwo extends Canvas implements Runnable {
    private Ball ball;

    public BallTestTwo() {
        setBackground(Color.WHITE);
        setVisible(true);

        ball = new Ball();

        System.out.println(ball);

        ball = new Ball(100, 90);
        System.out.println(ball);

        ball = new Ball(100, 100, 30, 50);
        System.out.println(ball);

        ball = new Ball(100, 100, 30, 50, Color.BLUE);
        System.out.println(ball);

        ball = new Ball(100, 100, 30, 50, Color.BLUE, 5, 6);
        System.out.println(ball);

        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        ball.moveAndDraw(window);

        if (!(ball.getX() >= 10 && ball.getX() <= 550)) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= 450)) {
            ball.setYSpeed(-ball.getYSpeed());
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread();
                Thread.sleep(19);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}