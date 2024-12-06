//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Doggies class to store Dog objects and return the oldest and youngest dog names

import java.util.Arrays;

public class Doggies {
	private Dog[] pups;

	public Doggies(int size) {
		pups = new Dog[size];
	}

	public void set(int spot, int age, String name) {
		pups[spot] = new Dog(age, name);
	}

	public String getNameOfOldest() {
		int max = 0;
		for (int i = 1; i < pups.length; i++) {
			if (pups[i].getAge() > pups[max].getAge()) {
				max = i;
			}
		}
		return pups[max].getName();
	}

	public String getNameOfYoungest() {
		int min = 0;
		for (int i = 1; i < pups.length; i++) {
			if (pups[i].getAge() < pups[min].getAge()) {
				min = i;
			}
		}
		
		return pups[min].getName();
	}

	public String toString() {
		return "" + Arrays.toString(pups);
	}
}