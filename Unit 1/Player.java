//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Player class to create a player object that sets the name and choice of the player

public class Player {
	private String name;
	private String choice;

	public Player(String nm) {
		name = nm;
	}

	public Player(String nm, String ch) {
		name = nm;
		choice = ch;
	}

	public void setName(String nm) {
		name = nm;
	}

	public void setChoice(String ch) {
		choice = ch;
	}

	public String getChoice() {
		return choice;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + " " + choice;
	}
}