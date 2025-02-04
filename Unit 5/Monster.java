//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Interface for Monster class

public interface Monster {
	public int getHowBig();

	public String getName();

	public boolean isBigger(Monster other);

	public boolean isSmaller(Monster other);

	public boolean namesTheSame(Monster other);
}