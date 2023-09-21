package Day4_CampCleanup;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// PLACE: ~99000 for part 1

public class Day4 {
    public static void main(String[] args) {
        File file = new File("src/rsc/Day4.txt");
        try {
            Scanner scanna = new Scanner(file);
            int total = 0;

            while (scanna.hasNextLine()) {
                String line = scanna.nextLine();
                // Split lines on the dash and then split the resulting string
                // on the comma
                String[] elf1Range = line.split(",")[0].split("-");
                String[] elf2Range = line.split(",")[1].split("-");

                // Loop until the arrays are filled from lowest to highest
                ArrayList<Integer> elf1Array = new ArrayList<>();
                for (int i = Integer.parseInt(elf1Range[0]); i <= Integer.parseInt(elf1Range[1]); i++) {
                    System.out.println("i: " + i);
                    elf1Array.add(i);
                }

                ArrayList<Integer> elf2Array = new ArrayList<>();
                for (int i = Integer.parseInt(elf2Range[0]); i <= Integer.parseInt(elf2Range[1]); i++) {
                    System.out.println("i: " + i);
                    elf2Array.add(i);
                }

                // Check if either array contains all the other array
                if (elf1Array.containsAll(elf2Array) || elf2Array.containsAll(elf1Array)) total++;
            }
            System.out.println("Total: " + total);
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
