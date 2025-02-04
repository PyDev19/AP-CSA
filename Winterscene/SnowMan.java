//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates a snowman and a tree in the winter scene project.

import java.awt.Color;
import java.awt.Graphics;

public class SnowMan extends AbstractShape {
    public SnowMan(int x, int y, int w, int h) {
        super(x, y, w, h, Color.WHITE, 0, 0);
    }

    public void draw(Graphics window) {
        // add code here to make a snowman
        window.fillOval(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
        window.fillOval(this.getXPos() - 5, this.getYPos() + 35, this.getWidth() + 10, this.getHeight() + 10);
        window.fillOval(this.getXPos() - 10, this.getYPos() + 70, this.getWidth() + 20, this.getHeight() + 20);

        // draw face
        window.setColor(Color.BLACK);
        window.fillOval(this.getXPos() + 10, this.getYPos() + 10, 5, 5); // left eye
        window.fillOval(this.getXPos() + 25, this.getYPos() + 10, 5, 5); // right eye
        window.setColor(Color.ORANGE);
        int[] xPoints = {this.getXPos() + 17, this.getXPos() + 22, this.getXPos() + 17};
        int[] yPoints = {this.getYPos() + 20, this.getYPos() + 25, this.getYPos() + 25};
        window.fillPolygon(xPoints, yPoints, 3); // nose

        window.setColor(Color.BLACK);
        window.drawString(":", this.getXPos() + 15, this.getYPos() + 65);
        window.drawString(":", this.getXPos() + 15, this.getYPos() + 100);
        window.drawString(".", this.getXPos() + 16, this.getYPos() + 107);

        // draw tree
        window.setColor(Color.ORANGE);
        window.fillRect(25, 520, 10, 40);
        window.setColor(Color.GREEN);
        window.fillRect(20, 450, 20, 50);
        window.fillRect(15, 500, 30, 30);

    }

    public void moveAndDraw(Graphics window) {
        draw(window);
    }
}