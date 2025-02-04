//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a ball object that can be used in the game. It extends the block class and has additional methods to set and get the speed of the ball. It also has a method to move and draw the ball on the screen. It also has a method to check if two balls are equal and a toString method to print the ball object.

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {
    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h) {
        super(x, y, w, h);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color col) {
        super(x, y, w, h, col);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, int xsp, int ysp) {
        super(x, y, w, h);
        xSpeed = xsp;
        ySpeed = ysp;
    }

    public Ball(int x, int y, int w, int h, Color col, int xsp, int ysp) {
        super(x, y, w, h, col);
        xSpeed = xsp;
        ySpeed = ysp;
    }

    // add the set methods
    public void setXSpeed(int s) {
        xSpeed = s;
    }

    public void setYSpeed(int s) {
        ySpeed = s;
    }

    public void moveAndDraw(Graphics window) {
        // draw a white ball at old ball location
        Ball replace = new Ball(getX(), getY(), getWidth(), getHeight(), Color.WHITE, 0, 0);
        replace.draw(window);
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        // setY
        // draw the ball at its new location
        draw(window);
    }

    public boolean equals(Object obj) {
        Block d = (Block) obj;
        if ((getX() == d.getX()) && (getY() == d.getY()) && (getWidth() == d.getWidth())
                && (getHeight() == d.getHeight()))
            return true;
        else
            return false;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    // add the get methods
    // add a toString() method
    public String toString() {
        return "" + super.toString() + ", " + getXSpeed() + ", " + getYSpeed();
    }
}
