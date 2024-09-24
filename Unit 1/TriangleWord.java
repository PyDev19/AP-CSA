//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class defines the triangle word and its methods, including the toString method.

public class TriangleWord {
	private String word;

	public TriangleWord(String w) {
		word = w;
	}

	public String toString() {
		String output = "";

		int length = word.length();

		for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < (length - i - 1); j++) {
                output += " ";
            }

            output += word.charAt(i);

            if (i > 0) {
                for (int j = 0; j < (i * 2 - 1); j++) {
                    output += " ";
                }
                output += word.charAt(i);
            }

            output += "\n";
        }

		for (int i = length - 1; i >= 0; i--) {
            output += word.charAt(i);
        }

		for (int i = 1; i < length; i++) {
            output += word.charAt(i);
        }

		return output + "\n";
	}
}