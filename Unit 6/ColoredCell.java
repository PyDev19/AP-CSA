//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is a subclass of Cell and is used to create a cell that can be filled with a color. It has methods to set and get the color and fill status of the cell. It also has a draw method that draws the cell on the screen.

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class ColoredCell extends Cell {
    private boolean filled;
    private Color color;

    public ColoredCell() {
        super(5, 5, 5, 5);
        setFilled(false);
        setColor(Color.BLUE);
    }

    public ColoredCell(boolean fill) {
        filled = fill;
        setColor(Color.BLUE);
    }

    public ColoredCell(int x, int y, boolean fill) {
        super(x, y);
        filled = fill;
        setColor(Color.BLUE);
    }

    public ColoredCell(int x, int y, int w, int h, boolean fill) {
        super(x, y, w, h);
        filled = fill;
        setColor(Color.BLUE);
    }

    public ColoredCell(int x, int y, int w, int h, boolean fill, Color c) {
        super(x, y, w, h);
        filled = fill;
        color = c;
    }

    public void setFilled(boolean fill) {
        filled = fill;
    }

    public void setColor(Color c) {
        color = c;
    }

    public boolean getFilled() {
        return filled;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Graphics window) {
        window.setFont(new Font("TAHOMA", Font.BOLD, 28));
        window.setColor(getColor());

        if (filled) {
            window.fillRect(getX(), getY(), getWidth(), getHeight());
        } else {
            window.drawRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    public String toString() {
        return super.toString() + " " + getFilled() + " " + getColor();
    }
}
