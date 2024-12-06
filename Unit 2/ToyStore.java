//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class that creates a toy store object with a list of toys that can be accessed and modified

import java.util.ArrayList;
import java.util.Arrays;

public class ToyStore {
	private ArrayList<Toy> toy_list;

	public ToyStore() {
		toy_list = new ArrayList<Toy>();
	}

	public void loadToys(String[] toys) {
		for (int i = 0; i < toys.length; i++) {
			String name = toys[i];
			if (toy_list.size() == 0) {
				toy_list.add(new Toy(name));
			} else {
				boolean found = false;
				for (int j = 0; j < toy_list.size(); j++) {
					if (toy_list.get(j).getName().equals(name)) {
						toy_list.get(j).setCount(toy_list.get(j).getCount() + 1);
						found = true;
					}
				}

				if (!found) {
					toy_list.add(new Toy(name));
				}
			}
		}
	}

	public Toy getThatToy(String nm) {
		int index = -1;
		for (int j = 0; j < toy_list.size(); j++) {
			if (toy_list.get(j).getName().equals(nm)) {
				index = j;
			}
		}

		return index == -1 ? null : toy_list.get(index);
	}

	public String getMostFrequentToy() {
		int max = Integer.MIN_VALUE;
		String name = "";
		for (int i = 0; i < toy_list.size(); i++) {
			if (toy_list.get(i).getCount() > max) {
				max = toy_list.get(i).getCount();
				name = toy_list.get(i).getName();
			}
		}

		return name;
	}

	public void sortToysByCount() {
	}

	public String toString() {
		return "" + Arrays.toString(toy_list.toArray());
	}
}