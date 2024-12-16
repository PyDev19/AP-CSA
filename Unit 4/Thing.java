//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Class to store information about objects in the forest, such as type, name, and size

public class Thing {
    private String type;
    private String name;
    private double size;

    public Thing(String t, String n, double s) {
        type = t;
        name = n;
        size = s;
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public void setType(String t) {
        type = t;
    }

    public void setSize(double s) {
        size = s;
    }

    public String toString() {
        return "" + type + " " + name + " " + String.format("%.2f", size) + " ";
    }
}