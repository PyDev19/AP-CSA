//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Mouse Button Tester to test for mouse button clicks and draw a rectangle at the location of the click

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseButtonTester extends JFrame implements MouseListener {
	private int mouseX, mouseY;
	private int mouseButton;
	private boolean isFirstRun;
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final long serialVersionUID = 0;

	public MouseButtonTester() {
		super("Mouse Button Tester");

		mouseX = mouseY = 0;
		mouseButton = 0;
		isFirstRun = true;

		setSize(WIDTH, HEIGHT);
		setBackground(Color.WHITE);
		setVisible(true);

		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		mouseButton = e.getButton();
		repaint();
	}

	public void paint(Graphics window) {
		if (isFirstRun) {
			window.setColor(Color.WHITE);
			window.fillRect(0, 0, WIDTH, HEIGHT);

			isFirstRun = false;
		}

		window.setFont(new Font("TAHOMA", Font.BOLD, 12));
		window.setColor(Color.BLUE);
		window.drawString("MOUSE BUTTON TESTER", 420, 55);

		draw(window);
	}

	public void draw(Graphics window) {
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		window.setColor(new Color(r, g, b));

		int w = (int) (Math.random() * 50) + 10;
		int h = (int) (Math.random() * 50) + 10;

		if (mouseButton == MouseEvent.BUTTON1) {
			window.drawRect(mouseX, mouseY, w, h);
		} else if (mouseButton == MouseEvent.BUTTON3) {
			window.drawOval(mouseX, mouseY, w, w);
		} else {
			window.drawRect(mouseX, mouseY, w, w);
		}
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered at: ");
		System.err.println("x: " + e.getX() + " y: " + e.getY());
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("Left");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed at: ");
		System.out.println("x: " + e.getX() + " y: " + e.getY());
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("Released at: ");
		System.out.println("x: " + e.getX() + " y: " + e.getY());
	}
}