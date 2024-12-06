//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a Tombstone object with the following attributes: name, burial date, age, and address. It also has methods to get and set the attributes, and a toString method to return the attributes in a formatted string.

public class Tombstone {
    private String name;
    private String burial_date;
    private int age;
    private String address;

    Tombstone() {
        name = "John Doe";
        burial_date = "January 1, 1970";
        age = 0;
        address = "123 Elm St.";
    }

    Tombstone(String name, String burial_date, int age, String address) {
        this.name = name;
        this.burial_date = burial_date;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getBurialDate() {
        return burial_date;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBurialDate(String burial_date) {
        this.burial_date = burial_date;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Name: " + name + "\nBurial Date: " + burial_date + "\nAge: " + age + "\nAddress: " + address;
    }
}
