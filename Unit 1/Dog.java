//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Makes a Dog object with a name and age and can increase the age by one, get the age, get the people age, and get the name

public class Dog {
    private int age;
    private String name;

    public Dog(String n) {
        age = 1;
        name = n;
    }

    public Dog(String n, int a) {
        age = a;
        name = n;
    }

    public void increaseAgeByOne() {
        age++;
    }

    public int getPeopleAge(int val) {
        int people_years = age * val;

        return people_years;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Dog - " + name + " " + age;
    }
}
