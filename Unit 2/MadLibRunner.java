//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class that runs the MadLib class and prints out the madlib

import static java.lang.System.*;

public class MadLibRunner {
	public static void main(String args[]) {
		MadLib test = new MadLib("story.dat");
		out.println(test);
	}
}