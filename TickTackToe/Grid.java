//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Grid class that creates a grid of cells and allows for the manipulation of the grid

import java.awt.Graphics;

public class Grid {
    private Cell[][] grid;

    public Grid() {
        setSize(0, 0);
    }

    public Grid(int rows, int cols) {
        setSize(rows, cols);
    }

    public void setSize(int rows, int cols) {
        grid = new Cell[rows][cols];
    }

    public void setSpot(int row, int col, Cell val) {
        grid[row][col] = val;
    }

    public Cell getSpot(int row, int col) {
        return grid[row][col];
    }

    public int getNumRows() {
        return grid.length;
    }

    public int getNumCols() {
        return grid[0].length;
    }

    public boolean drawGrid(Graphics window) {
        boolean full = true;

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] != null) {
                    grid[row][col].draw(window);
                } else {
                    full = false;
                }
            }
        }

        return full;
    }

    public String toString() {
        String output = "";

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                output += getSpot(row, col) + " ";
            }
        }

        return output;
    }
}