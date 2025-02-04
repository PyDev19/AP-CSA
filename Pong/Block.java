//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create the blocks that are used in the game. It has methods to set the color, x and y position, height and width of the block. It also has methods to get the color, x and y position, height and width of the block. It has a draw method that draws the block on the screen. It has an equals method that checks if two blocks are equal. It has a toString method that returns the x and y position, height, width and color of the block.

import java.awt.Color;
import java.awt.Graphics;

public class Block {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    public Block() {
        xPos = 0;
        yPos = 0;
        width = 0;
        height = 0;
        color = Color.BLACK;
    }

    public Block(int x, int y, int w, int h, Color c) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
    }

    public Block(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = Color.BLACK;
    }

    public Block(int x, int y) {
        xPos = x;
        yPos = y;
        width = 10;
        height = 50;
        color = Color.BLACK;
    }

    public void setColor(Color col) {
        color = col;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setHeight(int h) {
        height = h;
    }

    public void setWidth(int w) {
        width = w;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getWidth() + 10, getHeight() + 10);
    }

    public boolean equals(Object oj) {
        Block obj = (Block) oj;
        if ((color.equals(obj.getColor())) && (xPos == obj.getX()) && (yPos == obj.getY())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "" + getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight() + ", " + getColor();
    }
}
