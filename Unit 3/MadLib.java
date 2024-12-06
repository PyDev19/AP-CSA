//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - MadLibs class that reads from files and creates a madlib based on the nouns, verbs, and adjectives in the files

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;

public class MadLib {
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private String madlib;

	public MadLib() {
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		madlib = "";
	}

	public MadLib(String fileName) {
		madlib = "";
		try {
			Scanner file = new Scanner(new File(fileName));

			verbs = new ArrayList<String>();
			nouns = new ArrayList<String>();
			adjectives = new ArrayList<String>();

			loadNouns();
			loadVerbs();
			loadAdjectives();

			while (file.hasNext()) {
				Scanner line = new Scanner(file.nextLine());

				while (line.hasNext()) {
					String word = line.next();
					if (word.equals("#")) {
						madlib += getRandomNoun() + " ";
					} else if (word.equals("&")) {
						madlib += getRandomAdjective() + " ";
					} else if (word.equals("@")) {
						madlib += getRandomVerb() + " ";
					} else {
						madlib += word + " ";
					}
				}

				line.close();
				out.println();
			}

			file.close();
		} catch (Exception e) {
			out.println("Houston we have a problem!");
		}
	}

	public void loadNouns() {
		try {
			Scanner file = new Scanner(new File("nouns.dat"));

			while (file.hasNext()) {
				nouns.add(file.next());
			}

			file.close();
		} catch (Exception e) {
			out.println("nouns.dat not found");
		}
	}

	public void loadVerbs() {
		try {
			Scanner file = new Scanner(new File("verbs.dat"));

			while (file.hasNext()) {
				verbs.add(file.next());
			}

			file.close();
		} catch (Exception e) {
			out.println("verbs.dat not found");
		}
	}

	public void loadAdjectives() {
		try {
			Scanner file = new Scanner(new File("adjectives.dat"));

			while (file.hasNext()) {
				adjectives.add(file.next());
			}

			file.close();
		} catch (Exception e) {
			out.println("adjectives.dat not found");
		}
	}

	public String getRandomVerb() {
		int index = (int) (Math.random() * verbs.size());
		return verbs.get(index);
	}

	public String getRandomNoun() {
		int index = (int) (Math.random() * nouns.size());
		return nouns.get(index);
	}

	public String getRandomAdjective() {
		int index = (int) (Math.random() * adjectives.size());
		return adjectives.get(index);
	}

	public String toString() {
		return madlib;
	}
}