//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is a subclass of AbstractShape and it draws a fancy snowflake on the screen. It has a constructor that takes in the x and y position, width, height, x and y speed of the snowflake. It has a draw method that draws the snowflake on the screen and a moveAndDraw method that moves the snowflake and draws it on the screen. The snowflake moves in a diagonal direction.

import java.awt.Color;
import java.awt.Graphics;

public class FancySnowFlake extends AbstractShape {
    public FancySnowFlake(int x, int y, int w, int h, int xSpd, int ySpd) {
        super(x, y, w, h, Color.WHITE, xSpd, ySpd);
    }

    public void draw(Graphics window) {
        int centerX = this.getXPos() + this.getWidth() / 2;
        int centerY = this.getYPos() + this.getHeight() / 2;
        int radius = this.getWidth() / 2;

        window.setColor(Color.WHITE);

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(i * 60);
            int xEnd = centerX + (int) (radius * Math.cos(angle));
            int yEnd = centerY + (int) (radius * Math.sin(angle));
            window.drawLine(centerX, centerY, xEnd, yEnd);
        }
    }

    public void moveAndDraw(Graphics window) {
        this.setYPos(this.getYPos() + this.getYSpeed());
        if (this.getYPos() > 600)
            this.setYPos(0);

        this.setXPos(this.getXPos() + this.getXSpeed());
        if (this.getXPos() > 800)
            this.setXPos(0);

        draw(window);
    }
}
