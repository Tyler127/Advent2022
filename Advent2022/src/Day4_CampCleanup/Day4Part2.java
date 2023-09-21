package Day4_CampCleanup;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// Completed part 1 and 2 in ~40 minutes
// PLACE: ~1700 for part 1 and 2

public class Day4Part2 {
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

                // Fill both arrays from smallest to largest. including the largest
                ArrayList<Integer> elf1Array = new ArrayList<>();
                for (int i = Integer.parseInt(elf1Range[0]); i <= Integer.parseInt(elf1Range[1]); i++) {
                    elf1Array.add(i);
                }

                ArrayList<Integer> elf2Array = new ArrayList<>();
                for (int i = Integer.parseInt(elf2Range[0]); i <= Integer.parseInt(elf2Range[1]); i++) {
                    elf2Array.add(i);
                }

                if ( // Check if either contains edges of other array. (any overlap counts)
                    elf1Array.contains(elf2Array.get(0)) ||
                    elf1Array.contains(elf2Array.get(elf2Array.size()-1)) ||
                    elf2Array.contains(elf1Array.get(0)) ||
                    elf2Array.contains(elf1Array.get(elf1Array.size()-1))
                ) total++;
            }
            System.out.println("Total: " + total);
        }
        catch (Exception e) {e.printStackTrace();}
    }
}