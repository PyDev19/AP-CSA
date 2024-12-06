//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is responsible for initializing the shapes and moving them around the screen.

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MovingShapePanel extends JPanel implements Runnable {
	private Shape[] shapes;

	public MovingShapePanel() {
		setBackground(Color.WHITE);
		setVisible(true);

		shapes = new Shape[3];
		shapes[0] = new Shape(100, 100, 50, 50, Color.BLUE, 5, 5);
		shapes[1] = new Shape(50, 239, 50, 50, Color.RED, 5, 5);
		shapes[2] = new Shape(400, 435, 50, 50, Color.GREEN, 5, 5);

		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
		window.setFont(new Font("TAHOMA", Font.BOLD, 18));
		window.drawString("CREATE YOUR OWN SHAPE!", 40, 40);

		for (Shape shape : shapes) {
			// tell sh to move and draw
			shape.moveAndDraw(window);

			// this code handles the left and right walls
			if (!(shape.getX() >= 10 && shape.getX() <= 730)) {
				shape.setXSpeed(-shape.getXSpeed());
			}

			// add code to handle the top and bottom walls
			if (!(shape.getY() >= 10 && shape.getY() <= 530)) {
				shape.setYSpeed(-shape.getYSpeed());
			}
		}
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(10);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}