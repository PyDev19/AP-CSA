//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is a subclass of Ball that changes color every time it moves. It also has a randomColor method that generates a random color for the ball. The moveAndDraw method moves the ball and changes its color.

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball {
    public BlinkyBall() {
        super();
    }

    public BlinkyBall(int x, int y) {
        super(x, y);
    }

    public BlinkyBall(int x, int y, int wid, int ht) {
        super(x, y, wid, ht);
    }

    public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd) {
        super(x, y, wid, ht, xSpd, ySpd);
    }

    public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
        super(x, y, wid, ht, col, xSpd, ySpd);
    }

    public Color randomColor() {
        Random rng = new Random();
        int r = rng.nextInt(255); // use Math.random()
        int g = rng.nextInt(255);
        int b = rng.nextInt(255);
        return new Color(r, g, b);
    }

    public void moveAndDraw(Graphics window) {
        Ball replace = new Ball(getX(), getY(), getWidth(), getHeight(), Color.WHITE, 0, 0);
        replace.draw(window);

        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());
        setColor(randomColor());
        draw(window);
    }
}
