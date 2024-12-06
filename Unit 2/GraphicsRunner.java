//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This is the GraphicsRunner class that runs the MovingShapePanel class.

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner() {
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH, HEIGHT);

		// getContentPane().add(new ShapePanel());

		getContentPane().add(new MovingShapePanel());

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new GraphicsRunner();
	}
}