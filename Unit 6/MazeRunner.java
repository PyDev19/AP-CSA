//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeRunner {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(new File("maze.dat"));

        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();

            Maze maze = new Maze(size, line);

            System.out.print(maze);
            System.out.println();
        }

        scanner.close();
    }
}