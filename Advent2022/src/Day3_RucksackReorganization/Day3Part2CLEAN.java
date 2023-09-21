package Day3_RucksackReorganization;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class Day3Part2CLEAN {
    public static void main(String[] args) {
        File file = new File("src/rsc/Day3.txt");
        try {
            Scanner scanna = new Scanner(file);
            int total = 0;

            while (scanna.hasNextLine()) {
                String elfOneRucksack = scanna.nextLine();
                String elfTwoRucksack = scanna.nextLine();
                String elfThreeRucksack = scanna.nextLine();

                for (String currentString : elfOneRucksack.split("")) {
                    boolean inElf2Rucksack = Arrays.asList(elfTwoRucksack.split("")).contains(currentString);
                    boolean inElf3Rucksack = Arrays.asList(elfThreeRucksack.split("")).contains(currentString);

                    if (inElf2Rucksack && inElf3Rucksack) {
                        char currentChar = currentString.charAt(0);
                        if (isUpperCase(currentChar)) total += toLowerCase(currentChar) - 96 + 26;
                        else total += currentChar - 96;
                        break;
                    }
                }
            }
            System.out.println("Total: " + total);
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
