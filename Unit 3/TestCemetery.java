//Name- Atharva Mishra
//Class - Patterson 3B
//Description - This class runs a test on the cemetery class to find the average age of people who lived on Little Carter Lane

public class TestCemetery {
    public static void main(String[] args) {
        Cemetery cemetery = new Cemetery("cemetery.txt");

        double total = 0;
        int count = 0;

        for (Tombstone tombstone : cemetery.getTombstones()) {
            if (tombstone.getAddress().contains("Little Carter Lane")) {
                total += tombstone.getAge();
                count++;
            }
        }

        double avg_years = total / count / 365.0;

        System.out.println("Average age of everyone who lived on Little Carter Lane: " + avg_years + " years");
    }
}
