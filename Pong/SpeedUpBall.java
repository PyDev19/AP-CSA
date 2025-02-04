//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This is a subclass of the Ball class that adds the ability to speed up the ball when it hits a paddle.

import java.awt.Color;

class SpeedUpBall extends Ball {
    private int xSpeed;
    private int ySpeed;

    public SpeedUpBall() {
        super();
        xSpeed = 1;
        ySpeed = 1;
    }

    public SpeedUpBall(int x, int y) {
        super(x, y);
        xSpeed = 1;
        ySpeed = 1;
    }

    public SpeedUpBall(int x, int y, int xSpd, int ySpd) {
        super(x, y, 7, 10, xSpd, ySpd);
        xSpeed = xSpd;
        ySpeed = ySpd;
    }

    public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd) {
        super(x, y, wid, ht, xSpd, ySpd);
        xSpeed = xSpd;
        ySpeed = ySpd;
    }

    public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
        super(x, y, wid, ht, col, xSpd, ySpd);
        xSpeed = xSpd;
        ySpeed = ySpd;
    }

    public void setXSpeed(int xSpd) {
        if (xSpd < 0)
            xSpeed = xSpd - 2;
        else
            xSpeed = xSpd + 2;
        
        super.setXSpeed(xSpeed);
    }

    public void setYSpeed(int ySpd) {
        if (ySpd < 0)
            xSpeed = ySpd - 2;
        else
            xSpeed = ySpd + 2;
        
        super.setYSpeed(ySpeed);
    }
}
