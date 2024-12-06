//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class runs the Tablet class and tests the methods in it.

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Color;

public class DrawIt extends JFrame {
	public static int WIDTH = 800;
	public static int HEIGHT = 600;

	public DrawIt() {
		super("DrawIt");

		setSize(WIDTH, HEIGHT);
		setBackground(Color.BLACK);

		Tablet tb = new Tablet(this);
		((Component) tb).setFocusable(true);

		getContentPane().add(tb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		new DrawIt();
	}
}