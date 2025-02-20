import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class GarbageCollector extends JPanel implements MouseListener {
    private int mouse_x, mouse_y;
    private boolean mouse_clicked;
    private Grid trash_map;
    private final static int rows = 20;
    private final static int cols = 20;

    public GarbageCollector() {
        mouse_clicked = false;
        trash_map = new Grid(rows, cols);
        for (int r = 0; r < trash_map.getNumRows(); r++) {
            for (int c = 0; c < trash_map.getNumCols(); c++) {
                int num = (int) (Math.random() * 2);
                if (num == 1) {
                    trash_map.setSpot(r, c, new ColoredCell(r * rows + 10,
                            c * cols + 10, 10, 10, false, Color.ORANGE));
                } else {
                    trash_map.setSpot(r, c, new ColoredCell(r * rows + 10,
                            c * cols + 10, 10, 10, true, Color.GREEN));
                }
            }
        }
        setBackground(Color.white);
        setVisible(true);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        mouse_x = e.getX();
        mouse_y = e.getY();
        mouse_clicked = true;
        repaint();
    }

    public void paintComponent(Graphics window) {
        super.paintComponent(window);
        window.setFont(new Font("TAHOMA", Font.BOLD, 12));
        window.setColor(Color.blue);
        window.drawString("THE GARBAGE COLLECTOR LAB", 420, 55);
        if (mouse_clicked) {
            int c = mouse_y / cols;
            int r = mouse_x / rows;

            pickUpTrash(r, c);
            mouse_clicked = false;
        }
        drawTrashMap(window);
    }

    public void drawTrashMap(Graphics window) {
        trash_map.drawGrid(window);
    }

    public void pickUpTrash(int r, int c) {
        if ((r < trash_map.getNumRows()) && (c < trash_map.getNumCols()) && (r >= 0) && (c >= 0)) {
            ColoredCell val = (ColoredCell) trash_map.getSpot(r, c);
            if (val.getFilled() && (val.getColor() == Color.GREEN)) {
                trash_map.setSpot(r, c, new ColoredCell(r * rows + 10, c * cols + 10, 10, 10, true, Color.BLUE));
                repaint();
                pickUpTrash(r - 1, c);
                pickUpTrash(r + 1, c);
                pickUpTrash(r, c - 1);
                pickUpTrash(r, c + 1);
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}