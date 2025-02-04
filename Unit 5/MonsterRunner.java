//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates two monsters and compares their sizes.

import java.util.Scanner;

public class MonsterRunner {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter 1st monster's name (Skeleton): ");
		String name = keyboard.next();
		System.out.print("Enter 1st monster's size (Skeleton): ");
		int size = keyboard.nextInt();

		Skeleton monster_1 = new Skeleton(name, size);

		System.out.print("Enter 2nd monster's name (Zombie): ");
		name = keyboard.next();
		System.out.print("Enter 2nd monster's size (Zombie): ");
		size = keyboard.nextInt();

		Zombie monster_2 = new Zombie(name, size);

		System.out.println("Monster 1 - " + monster_1);
		System.out.println("Monster 2 - " + monster_2);

		if (monster_1.isBigger(monster_2)) {
			System.out.println("Monster one is bigger than Monster two.");
		} else if (monster_1.isSmaller(monster_2)) {
			System.out.println("Monster one is smaller than Monster two.");
		} else {
			System.out.println("Monster one is the same size as Monster two.");
		}

		if (monster_1.namesTheSame(monster_2)) {
			System.out.println("Monster one has the same name as Monster two.");
		} else {
			System.out.println("Monster one does not have the same name as Monster two.");
		}

		keyboard.close();
	}
}