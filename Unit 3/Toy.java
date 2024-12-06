//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class that creates a toy object with a name and count that can be accessed and modified

class Toy {
    private String name;
    private int count;

    public Toy() {
        name = "";
        count = 1;
    }

    public Toy(String n) {
        name = n;
        count = 1;
    }

    public Toy(String n, int c) {
        name = n;
        count = c;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(String n) {
        name = n;
    }

    public void setCount(int c) {
        count = c;
    }

    public String toString() {
        return name + " " + count;
    }
}