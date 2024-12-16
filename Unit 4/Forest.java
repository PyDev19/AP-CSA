//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class stores the entire forest and all the things in it. It checks if a thing is trapped and sets it to null if it is.

import java.util.Random;

public class Forest {
	private Thing[][] grid;

	public Forest(int rows, int cols) {
		final String[] typeList = "cat dog tree rock".split(" ");
		final String[] nameList = "a b c d e f g h i j k l m n o p q r t s u v w x y z".split(" ");
		Random random = new Random();

		grid = new Thing[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int type = random.nextInt(typeList.length);
				int name = random.nextInt(nameList.length);
				double size = 5.0 + (35.0 - 5.0) * random.nextDouble();

				grid[r][c] = new Thing(typeList[type], nameList[name], size);
			}
		}
	}

	public int setTrappedToNull() {
		int count = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (isTrapped(r, c)) {
					grid[r][c] = null;
					count++;
				}
			}
		}

		return count;
	}

	public boolean isTrapped(int r, int c) {
		if (grid[r][c] == null)
			return false;

		String type = grid[r][c].getType();
		if (type.equals("rock") || type.equals("tree")) {
			return false;
		}

		int count = 0;
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if ((i == r && j == c) || !inBounds(i, j) || grid[i][j] == null) {
					continue;
				}

				String neighbor_type = grid[i][j].getType();
				double neighbor_size = grid[i][j].getSize();

				if ((neighbor_type.equals("rock") || neighbor_type.equals("tree")) && neighbor_size >= 10.0) {
					count++;
				}

				if (count >= 5) {
					break;
				}
			}
		}

		return count >= 5;
	}

	private boolean inBounds(int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
	}

	public String toString() {
		String output = "";
		for (Thing[] row : grid) {
			for (Thing thing : row) {
				output += String.format("%-15s", thing == null ? "null" : thing);
			}
			output += "\n";
		}

		return output;
	}
}
