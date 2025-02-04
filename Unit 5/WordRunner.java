//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class that runs and tests the word class by sorting via lenght and number of vowels

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class WordRunner {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("word.dat"));
		List<Word> list = new ArrayList<Word>();

		int size = file.nextInt();

		for (int i = 0; i < size; i++) {
			String s = file.next();
			list.add(new Word(s));
		}

		System.out.println("Sorted by lenght: ");
		list.sort((a, b) -> {
			int length_comparison = Integer.compare(a.toString().length(), b.toString().length());
			if (length_comparison != 0) {
				return length_comparison;
			}
			return a.toString().compareTo(b.toString());
		});
		for (Word w : list) {
			System.out.println(w);
		}

		System.out.println("\nSorted by vowels: ");
		list.sort((a, b) -> {
			int vowel_comparison = a.compareTo(b);
			if (vowel_comparison != 0) {
				return vowel_comparison;
			}
			return a.toString().compareTo(b.toString());
		});
		for (Word w : list) {
			System.out.println(w);
		}

		file.close();
	}
}