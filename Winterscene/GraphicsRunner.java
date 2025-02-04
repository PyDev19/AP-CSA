//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class runs the WinterScene inside a JFrame

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public GraphicsRunner() {
        super("THE WINTER SCENE PROJECT");
        setSize(WIDTH, HEIGHT);

        getContentPane().add(new WinterScenePanel());

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new GraphicsRunner();
    }
}