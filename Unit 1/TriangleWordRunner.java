//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class runs the triangle word and asks user for the word.

import java.util.Scanner;

public class TriangleWordRunner {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = keyboard.next();

        TriangleWord triangle = new TriangleWord(word);
        System.out.println(triangle);

        keyboard.close();
    }
}