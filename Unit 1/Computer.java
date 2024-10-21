//(c) A+ Computer Science 
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Computer class to create a computer object that plays rock paper scissors against the player object by generating a random choice

public class Computer {
	// instance / member variables
	private String choice;

	public Computer() {
		// call random set Choice
		randomSetChoice();
	}

	public String getChoice() {
		return choice;
	}

	public void randomSetChoice() {
		// use Math.random()
		// use switch case
		int choice = (int) (Math.random() * 3);
		switch (choice) {
			case 0:
				this.choice = "rock";
				break;
			case 1:
				this.choice = "paper";
				break;
			case 2:
				this.choice = "scissors";
				break;
		}
	}

	/*
	 * didIWin(Player p) will return the following values
	 * 0 - both players have the same choice
	 * 1 - the computer had the higher ranking choice
	 * -1 - the player had the higher ranking choice
	 */
	public int didIWin(Player p) {
		if (choice.equals(p.getChoice())) {
			return 0;
		} else if (choice.equals("rock") && p.getChoice().equals("scissors")) {
			return 1;
		} else if (choice.equals("scissors") && p.getChoice().equals("paper")) {
			return 1;
		} else if (choice.equals("paper") && p.getChoice().equals("rock")) {
			return 1;
		} else {
			return -1;
		}
	}

	public String toString() {
		return "pooter " + choice;
	}
}