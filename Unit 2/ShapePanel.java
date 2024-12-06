//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates a shape on the screen

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapePanel extends JPanel {
	public ShapePanel() {
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	/*
	 * All of your test code should be placed in paint.
	 */
	public void paint(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
		window.setFont(new Font("TAHOMA", Font.BOLD, 18));
		window.drawString("CREATE YOUR OWN SHAPE!", 40, 40);

		// make a Shape
		Shape s = new Shape(100, 100, 50, 50, Color.BLUE, 5, 5);
		
		// draw the Shape
		s.draw(window);
	}
}