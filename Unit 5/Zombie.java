//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Zombie class that implements Monster interface and has methods to compare monsters

public class Zombie implements Monster {
	String name;
	int size;

	public Zombie() {
		name = "";
		size = 0;
	}

	public Zombie(String n, int s) {
		name = n;
		size = s;
	}

	public int getHowBig() {
		return size;
	}

	public String getName() {
		return name;
	}

	public boolean isBigger(Monster other) {
		return this.size > other.getHowBig();
	}

	public boolean isSmaller(Monster other) {
		return this.size < other.getHowBig();
	}

	public boolean namesTheSame(Monster other) {
		return this.name.equals(other.getName());
	}

	public String toString() {
		return name + " " + size;
	}
}