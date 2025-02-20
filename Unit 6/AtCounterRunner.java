//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to test the AtCounter class and its methods. It creates an object of the AtCounter class and calls the countAts method to count the number of @s connected in the 2D array.

public class AtCounterRunner {
    public static void main(String args[]) {
        AtCounter counter = new AtCounter();
        System.out.println(counter);

        System.out.println("The number of @s connected at (0, 0): " + counter.countAts(0, 0));

        counter.clear_visited();

        System.out.println("The number of @s connected at (2, 5): " + counter.countAts(2, 5));
        
        counter.clear_visited();

        System.out.println("The number of @s connected at (5, 0): " + counter.countAts(5, 0));
        
        counter.clear_visited();

        System.out.println("The number of @s connected at (9, 9): " + counter.countAts(9, 9));
        
        counter.clear_visited();

        System.out.println("The number of @s connected at (3, 9): " + counter.countAts(3, 9));
    }
}