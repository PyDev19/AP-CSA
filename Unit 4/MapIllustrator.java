//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class draws the map of the given terrain from a file and finds the best path to travel from west to east with the least elevation change.

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapIllustrator {
	/** the 2D array containing the elevations */
	private int[][] grid;

	/** constructor, parses input from the file into grid */
	public MapIllustrator(String fileName) throws IOException {
		Scanner file = new Scanner(new File(fileName));

		int rows = file.nextInt();
		int cols = file.nextInt();
		grid = new int[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c] = file.nextInt();
			}
		}

		file.close();
	}

	/** @return the min value in the entire grid */
	public int findMin() {
		int min = Integer.MAX_VALUE;
		for (int[] row : grid) {
			for (int value : row) {
				min = Math.min(min, value);
			}
		}

		return min;
	}

	/** @return the max value in the entire grid */
	public int findMax() {
		int max = Integer.MIN_VALUE;
		for (int[] row : grid) {
			for (int value : row) {
				max = Math.max(max, value);
			}
		}

		return max;
	}

	/**
	 * Draws the grid using the given Graphics object.
	 * Colors should be grayscale values 0-255, scaled based on min/max values in
	 * grid
	 */
	public void drawMap(Graphics g) {
		int min = findMin();
		int max = findMax();
		int range = max - min;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				int value = grid[r][c];
				int colorValue = (int) (255 * (value - min) / range);
				g.setColor(new Color(colorValue, colorValue, colorValue));
				g.fillRect(c, r, 1, 1);
			}
		}
	}

	/**
	 * Find a path from West-to-East starting at given row.
	 * Choose a forward step out of 3 possible forward locations, using greedy
	 * method described in assignment.
	 * 
	 * @return the total change in elevation traveled from West-to-East
	 */
	public int drawPath(Graphics g, int row) {
		int total_change = 0;
		int current_row = row;
		int current_col = 0;

		while (current_col < grid[0].length - 1) {
			int current_elevation = grid[current_row][current_col];
			int forward_elevation = grid[current_row][current_col + 1];

			int up_elevation = 0;
			if (current_row > 0) {
				up_elevation = grid[current_row - 1][current_col + 1];
			} else {
				up_elevation = Integer.MAX_VALUE;
			}

			int down_elevation = 0;
			if (current_row < grid.length - 1) {
				down_elevation = grid[current_row + 1][current_col + 1];
			} else {
				down_elevation = Integer.MAX_VALUE;
			}


			int min_change = Math.abs(forward_elevation - current_elevation);
			int next_row = current_row;

			if (Math.abs(up_elevation - current_elevation) < min_change) {
				min_change = Math.abs(up_elevation - current_elevation);
				next_row = current_row - 1;
			}

			if (Math.abs(down_elevation - current_elevation) < min_change) {
				min_change = Math.abs(down_elevation - current_elevation);
				next_row = current_row + 1;
			}

			total_change += min_change;
			g.fillRect(current_col + 1, current_row, 1, 1);

			current_col++;
			current_row = next_row;
		}

		return total_change;
	}

	/**
	 * @return the index of the starting row for the lowest-elevation-change path in
	 *         the entire grid.
	 */
	public int getIndexOfLowestPath(Graphics g) {
		int min_change = Integer.MAX_VALUE;
		int best_row = 0;

		for (int r = 0; r < grid.length; r++) {
			int change = drawPath(g, r);
			if (change < min_change) {
				min_change = change;
				best_row = r;
			}
		}

		return best_row;
	}

	/** return the number of rows in grid */
	public int getRows() {
		int rows = grid.length;
		return rows;
	}

	/** return the number of columns in grid (assumed rectangular) */
	public int getCols() {
		int cols = grid[0].length;
		return cols;
	}
}
