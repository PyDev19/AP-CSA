//Name- Atharva Mishra
//Class - Patterson 3B
//Description - This class reads a file and creates a list of tombstones. It also has a method to sort the tombstones by date.

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Cemetery {
    private ArrayList<Tombstone> tombstones;

    public Cemetery() {
        tombstones = new ArrayList<Tombstone>();
    }

    public Cemetery(String file_name) {
        tombstones = new ArrayList<Tombstone>();

        try {
            Scanner file = new Scanner(new File(file_name));
            String name = "";
            int age = 0;
            String burial_date = "";
            String address = "";
            int temp = 0;

            while (file.hasNext()) {
                Scanner line = new Scanner(file.nextLine());
                
                while (true) {
                    try {
                        temp = line.nextInt();
                        break;
                    } catch (Exception e) {
                        name += " " + line.next();
                    }
                }

                burial_date = temp + " " + line.next() + " " + line.next();
                age = parseAge(line.next());
                while (line.hasNext()) {
                    address += " " + line.next();
                }

                tombstones.add(new Tombstone(name, burial_date, age, address));

                name = "";
                burial_date = "";
                address = "";
                age = 0;

                line.close();
            }


            file.close();
        } catch (Exception e) {
            System.out.println(file_name + " not found");
        }
    }

    public static int parseAge(String ageString) {
        if (ageString.contains("d")) {
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }

        int result = 0;
        boolean done = true;

        try {
            result = Integer.parseInt(ageString);
        } catch (NumberFormatException n) {
            done = false;
        }

        if (done)
            return 365 * result;
        
        double ageDouble = 0;
        done = true;

        try {
            ageDouble = Double.parseDouble(ageString);
        } catch (NumberFormatException n) {
            done = false;
        }
        
        if (done) {
            return (int) (ageDouble * 365);
        }

        if (ageString.contains("w")) {
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }
        
        return 0;
    }

    public void sortTombstones() {
        for (int i = 0; i < tombstones.size(); i++) {
            for (int j = i + 1; j < tombstones.size(); j++) {
                if (tombstones.get(i).getBurialDate().compareTo(tombstones.get(j).getBurialDate()) > 0) {
                    Tombstone temp = tombstones.get(i);
                    tombstones.set(i, tombstones.get(j));
                    tombstones.set(j, temp);
                }
            }
        }
    }


    public ArrayList<Tombstone> getTombstones() {
        return tombstones;
    }
}