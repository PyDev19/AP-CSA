//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson	3B
//Description - Makes a Robot object with a head, upper body, and lower body

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner() {
		super("Graphics Runner");

		setSize(WIDTH, HEIGHT);

		getContentPane().add(new Robot());

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		GraphicsRunner run = new GraphicsRunner();
	}
}