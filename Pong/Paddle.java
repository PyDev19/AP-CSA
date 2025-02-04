//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a paddle in the game. It has methods to move the paddle up and down and also has a method to get the speed of the paddle. It also has a toString method to return the string representation of the paddle.

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
    private int speed;

    public Paddle() {
        super(10, 10);
        speed = 5;
    }

    public Paddle(int s) {
        super(10, 10);
        speed = s;
    }

    public Paddle(int x, int y) {
        super(x, y);
        speed = 5;
    }

    public Paddle(int x, int y, int s) {
        super(x, y);
        speed = s;
    }

    public Paddle(int x, int y, int w, int h, Color col, int s) {
        super(x, y, w, h, col);
        speed = s;
    }

    public Paddle(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
    }

    // add the other Paddle constructors
    public void moveUpAndDraw(Graphics window) {
        Paddle replace = new Paddle(getX(), getY(), getWidth() + 10, getHeight() + 10, Color.WHITE, 0);
        replace.draw(window);
        setY(getY() - speed);
        draw(window);
    }

    public void moveDownAndDraw(Graphics window) {
        Paddle replace = new Paddle(getX(), getY(), getWidth() + 10, getHeight() + 10, Color.WHITE, 0);
        replace.draw(window);
        setY(getY() + speed);
        draw(window);
    }

    // add get methods
    // add a toString() method
    public int getSpeed() {
        return speed;
    }

    public String toString() {
        return "" + super.toString() + getSpeed();
    }
}
