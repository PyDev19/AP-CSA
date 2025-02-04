//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Word class that implements the Comparable interface and compares the number of vowels in two words

public class Word implements Comparable<Word> {
	private String word;

	public Word(String s) {
		word = s;
	}

	private int numVowels() {
		String vowels = "AEIOUaeiou";
		int vowelCount = 0;

		for (int i = 0; i < word.length(); i++) {
			if (vowels.indexOf(word.charAt(i)) != -1) {
				vowelCount++;
			}
		}

		return vowelCount;
	}

	public int compareTo(Word rhs) {
		return this.numVowels() - rhs.numVowels();
	}

	public String toString() {
		return word;
	}
}