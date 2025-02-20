//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to find the number of times the word "chicken" appears in a string using recursion.

public class RecursionFunTwo {
    public static int countChickens(String word) {
        if (word.length() < 7 || word.indexOf("chicken") == -1) {
            return 0;
        } else {
            return 1 + countChickens(word.substring(0, word.indexOf("chicken")) + word.substring(word.indexOf("chicken") + 7));
        }
    }
}