//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates the game board for the TicTacToe game and checks for win conditions

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Canvas;

public class GameBoard extends Canvas implements MouseListener {
    private int mouseX, mouseY;
    private boolean mouseClicked;
    private int mouseButton, prevMouseButton;
    private Grid board;
    private boolean isXTurn;

    private final static int WIDTH = 150;
    private final static int HEIGHT = 150;
    private final static int BOARDSIZE = 3;

    public GameBoard() {
        mouseClicked = false;
        mouseX = mouseY = 0;
        mouseButton = 0;
        prevMouseButton = -1;
        isXTurn = true;

        board = new Grid(BOARDSIZE, BOARDSIZE);

        addMouseListener(this);
        setBackground(Color.WHITE);
    }

    public void mouseClicked(MouseEvent e) {
        mouseClicked = true;
        mouseX = e.getX();
        mouseY = e.getY();
        mouseButton = e.getButton();
        repaint();
    }

    public void paint(Graphics window) {
        window.setColor(Color.white);
        window.fillRect(0, 0, 640, 480);
        window.setFont(new Font("TAHOMA", Font.BOLD, 12));
        window.setColor(Color.blue);
        window.drawString("TIC TAC TOE", 420, 55);
        window.drawString("left mouse click == [X]", 420, 85);
        window.drawString("right mouse click == [O]", 420, 105);

        window.drawRect(50, 50, WIDTH, HEIGHT);
        window.drawRect(100, 50, WIDTH / 3, HEIGHT);
        window.drawRect(50, 100, WIDTH, HEIGHT / 3);

        if (mouseClicked) {
            markBoard();
            board.drawGrid(window);

            if (determineWinner(window)) {
                board = new Grid(BOARDSIZE, BOARDSIZE);
                window.setColor(Color.white);
                isXTurn = true;
            }
            mouseClicked = false;
        }
    }

    public void markBoard() {
        if (mouseX >= WIDTH / 3 && mouseX <= WIDTH + 50 && mouseY >= HEIGHT / 3 && mouseY <= HEIGHT + 50) {
            int r = mouseY / 50 - 1;
            int c = mouseX / 50 - 1;
            Piece piece = (Piece) board.getSpot(r, c);

            if (piece == null) {
                if (isXTurn && mouseButton == MouseEvent.BUTTON1) {
                    board.setSpot(r, c, new Piece(5 + c * 50 + 65, 5 + r * 50 + 80, WIDTH / 3 - 10, HEIGHT / 3 - 10, "X", Color.RED));
                    isXTurn = false;
                } else if (!isXTurn && mouseButton == MouseEvent.BUTTON3) {
                    board.setSpot(r, c, new Piece(5 + c * 50 + 65, 5 + r * 50 + 80, WIDTH / 3 - 10, HEIGHT / 3 - 10, "O", Color.BLUE));
                    isXTurn = true;
                }
            }
        }
    }

    public boolean determineWinner(Graphics window) {
        String winner = "";
        for (int r = 0; r < board.getNumRows(); r++) {
            Piece row0 = (Piece) board.getSpot(r, 0);
            Piece row1 = (Piece) board.getSpot(r, 1);
            Piece row2 = (Piece) board.getSpot(r, 2);

            if (row0 == null || row1 == null || row2 == null)
                continue;

            if (row0.getName().equals(row1.getName()) && row0.getName().equals(row2.getName())) {
                winner = row0.getName() + " wins horizontally!";
                break;
            }
        }

        if (winner.equals("")) {
            for (int c = 0; c < board.getNumCols(); c++) {
                Piece col0 = (Piece) board.getSpot(0, c);
                Piece col1 = (Piece) board.getSpot(1, c);
                Piece col2 = (Piece) board.getSpot(2, c);

                if (col0 == null || col1 == null || col2 == null)
                    continue;

                if (col0.getName().equals(col1.getName()) && col0.getName().equals(col2.getName())) {
                    winner = col0.getName() + " wins vertically!";
                    break;
                }
            }
        }

        if (winner.equals("")) {
            Piece diag0 = (Piece) board.getSpot(0, 0);
            Piece diag1 = (Piece) board.getSpot(1, 1);
            Piece diag2 = (Piece) board.getSpot(2, 2);

            if (diag0 != null && diag1 != null && diag2 != null) {
                if (diag0.getName().equals(diag1.getName()) && diag0.getName().equals(diag2.getName())) {
                    winner = diag0.getName() + " wins diagonally!";
                }
            }

            diag0 = (Piece) board.getSpot(0, 2);
            diag1 = (Piece) board.getSpot(1, 1);
            diag2 = (Piece) board.getSpot(2, 0);

            if (diag0 != null && diag1 != null && diag2 != null) {
                if (diag0.getName().equals(diag1.getName()) && diag0.getName().equals(diag2.getName())) {
                    winner = diag0.getName() + " wins diagonally!";
                }
            }
        }

        if (winner.length() > 0) {
            window.setFont(new Font("TAHOMA", Font.BOLD, 22));
            window.setColor(Color.orange);
            window.drawString(winner, 320, 355);
            try {
                Thread.sleep(1500);
            } catch (Exception e) {}
            repaint();
            return true;
        }
        return false;
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
