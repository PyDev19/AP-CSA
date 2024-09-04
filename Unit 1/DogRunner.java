//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Makes a Dog object with a name and age and can increase the age by one, get the age, get the people age, and get the name

public class DogRunner {
	public static void main(String[] args) {
		Dog d = new Dog("Rover");
		System.out.println(d.getPeopleAge(7));

		d.increaseAgeByOne();
		d.increaseAgeByOne();

		System.out.println(d.getPeopleAge(11));
		System.out.println(d.getName());

		d.increaseAgeByOne();
		d.increaseAgeByOne();
		d.increaseAgeByOne();
		d.increaseAgeByOne();

		System.out.println(d.getPeopleAge(8));

		Dog g = new Dog("bob", 3);
		System.out.println(g.getName());
		System.out.println(g.getPeopleAge(5));
	}
}