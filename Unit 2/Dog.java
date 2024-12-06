//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Dog class that has a name and age and can be printed out

public class Dog {
    private int age;
    private String name;

    public Dog(int a, String n) {
        age = a;
        name = n;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "" + age + " " + name;
    }
}