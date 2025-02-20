//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to make a 10x10 grid of random "@" and "-" characters and find the number of "@" characters connected to the starting point using recursion.

import java.util.Random;

public class AtCounter {
    private String[][] grid;
    private int[][] visited;
    private Random random = new Random();

    public AtCounter() {
        grid = new String[10][10];
        visited = new int[10][10];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int rng_val = random.nextInt(9) + 1;
                if (rng_val % 2 == 0) {
                    grid[r][c] = "@";
                } else {
                    grid[r][c] = "-";
                }
            }
        }
    }

    public int countAts(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) {
            return 0;
        }

        if (!grid[r][c].equals("@") || visited[r][c] == 1) {
            return 0;
        }

        visited[r][c] = 1;

        return 1 + countAts(r - 1, c) + countAts(r + 1, c) + countAts(r, c - 1) + countAts(r, c + 1);
    }

    public void clear_visited() {
        for (int r = 0; r < visited.length; r++) {
            for (int c = 0; c < visited[r].length; c++) {
                visited[r][c] = 0;
            }
        }
    }

    public String toString() {
        String output = "";

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                output += grid[r][c] + " ";
            }
            output += "\n";
        }

        return output;
    }
}