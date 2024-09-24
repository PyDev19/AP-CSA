//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class has methods that manipulate strings in various ways. It has methods that return the first and last letters of a string, the middle letter of a string, the difference in ASCII values between a string and a given letter, and whether the first and last letters of a string are the same.

public class StringStuff {
	private String word;

	public StringStuff(String w) {
		word = w;
	}

	public String getFirstLastLetters() {
		String firstLetter = word.substring(0, 1);
		String lastLetter = word.substring(word.length() - 1);

		return firstLetter + lastLetter;
	}

	public String getMiddleLetter() {
		String middleLetter = word.substring(word.length() / 2, word.length() / 2 + 1);

		return middleLetter;
	}

	public int diffInASCII(String letter) {
		return word.compareTo(letter);
	}

	public boolean sameFirstLastLetters() {
		String firstLetter = word.substring(0, 1);
		String lastLetter = word.substring(word.length() - 1);

		return firstLetter.equals(lastLetter);
	}

	public String toString() {
		return "" + word;
	}
}