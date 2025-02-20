//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to test the RecursionFunTwo class and its countChickens method.

public class RecursionRunner {
    public static void main(String args[]) {
        String[] test_cases = { "itatfun", "itatchickenfun", "chchickchickenenicken", "chickchickfun",
                "chickenbouncetheballchicken" };

        int[] expected_results = { 0, 1, 3, 0, 2 };

        for (int i = 0; i < test_cases.length; i++) {
            System.out.println("The word \"chicken\" appears " + RecursionFunTwo.countChickens(test_cases[i])
                    + " times in the string \"" + test_cases[i] + "\".");
            System.out.println("Expected: " + expected_results[i]);
            System.out.println();
        }
    }
}