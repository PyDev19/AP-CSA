//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This draws the snow man and tree as well as randomly falling snowflakes in the winter scene project.

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.*;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

public class WinterScenePanel extends JPanel implements Runnable {
    private List<AbstractShape> shapes;
    private AbstractShape snowman;

    public WinterScenePanel() {
        setVisible(true);

        shapes = new ArrayList<AbstractShape>();
        for (int i = 50; i > 0; i--) {
            Random rng = new Random();
            int xPos = rng.nextInt(800) + 1;
            int YPos = rng.nextInt(600) + 1;
            int width = rng.nextInt(40) + 1;
            int height = rng.nextInt(40) + 1;
            int speed = rng.nextInt(20) + 1;
            int xSpeed = rng.nextInt(3) + 1;
            FancySnowFlake flake = new FancySnowFlake(xPos, YPos, width, height, xSpeed, speed);
            shapes.add(flake);
        }

        snowman = new SnowMan(700, 410, 40, 40);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        window.setColor(Color.BLUE);
        window.fillRect(0, 0, getWidth(), getHeight());
        window.setColor(Color.WHITE);
        window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        window.setFont(new Font("TAHOMA", Font.BOLD, 18));
        window.drawString("MAKE A WINTER SCENE!", 40, 40);
        snowman.draw(window);

        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).moveAndDraw(window);
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread();
                Thread.sleep(35);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
