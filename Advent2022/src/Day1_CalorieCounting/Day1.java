package Day1_CalorieCounting;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Day1 {
     public static void main(String[] args) {
        File file = new File("src/rsc/Day1.txt");
        try {
            Scanner scanna = new Scanner(file);
            List<Integer> elfCalorieSums = new ArrayList<>();

            int currentSum = 0;
            while(scanna.hasNextLine()) {
                String line = scanna.nextLine();

                if (line == "") {
                    elfCalorieSums.add(currentSum);
                    currentSum = 0;
                } else {
                    currentSum +=  parseInt(line);
                }
            }
            Collections.sort(elfCalorieSums);
            Collections.reverse(elfCalorieSums);
            System.out.println("Largest Amount of Calories: " + elfCalorieSums.get(0));

            int topThreeElves = 0;
            for (int i = 0; i < 3; i++){topThreeElves += elfCalorieSums.get(i);}
            System.out.println("Top 3 Elves Total Calories: " + topThreeElves);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}