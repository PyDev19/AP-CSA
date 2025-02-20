import java.util.Scanner;

public class Maze {
    private int[][] maze;
    private int[][] visited;
    private int[][] distance;

    public Maze(int size, String line) {
        Scanner scanner = new Scanner(line);

        maze = new int[size][size];
        visited = new int[size][size];
        distance = new int[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                maze[r][c] = scanner.nextInt();
            }
        }

        scanner.close();
    }

    public boolean hasExitPath(int r, int c, int steps) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze.length) {
            return false;
        }

        if (maze[r][c] == 0 || visited[r][c] == 1) {
            return false;
        }

        if (c == maze.length - 1) {
            distance[r][c] = steps;
            return true;
        }

        visited[r][c] = 1;
        distance[r][c] = steps;

        boolean found_path = hasExitPath(r, c + 1, steps + 1) || hasExitPath(r + 1, c, steps + 1)
                || hasExitPath(r - 1, c, steps + 1) || hasExitPath(r, c - 1, steps + 1);

        visited[r][c] = 0;

        return found_path;
    }

    public boolean hasExitPath(int r, int c) {
        return hasExitPath(r, c, 0);
    }

    public int getStepsToExit() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze.length; c++) {
                if (c == maze.length - 1 && distance[r][c] > 0) {
                    return distance[r][c];
                }
            }
        }
        return -1; // No path found
    }

    public String toString() {
        String output = "";
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze.length; c++) {
                output += maze[r][c] + " ";
            }
            output += "\n";
        }

        boolean hasPath = hasExitPath(0, 0);
        int steps = getStepsToExit();

        output += "Exit path " + (hasPath ? "found, steps: " + steps : "not found") + "\n";

        return output;
    }
}