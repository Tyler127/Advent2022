package Day3_RucksackReorganization;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

// Correct Answer: 2510

public class Day3Part2 {
    public static void main(String[] args) {
        File file = new File("src/rsc/Day3.txt");
        try {
            Scanner scanna = new Scanner(file);
            int total = 0;

            while (scanna.hasNextLine()) {
                // Grabs three lines at a time
                String[] currentLines = {scanna.nextLine(), scanna.nextLine(), scanna.nextLine()};

                String elfOneRucksack = currentLines[0];
                String elfTwoRucksack = currentLines[1];
                String elfThreeRucksack = currentLines[2];

                // Splits line 1 into an array of 1 length strings and iterates over them
                for (String currentString : elfOneRucksack.split("")) {
                    // Checks if the string is in both of the other strings
                    boolean inElf2Rucksack = Arrays.asList(elfTwoRucksack.split("")).contains(currentString);
                    boolean inElf3Rucksack = Arrays.asList(elfThreeRucksack.split("")).contains(currentString);

                    System.out.println("currentString: " + currentString);
                    System.out.println("    in 2nd: " + inElf2Rucksack);
                    System.out.println("    in 3rd: " + inElf3Rucksack);

                    // Only runs if the character is in both strings (there will only be one common char in all 3)
                    if (inElf2Rucksack && inElf3Rucksack) {
                        char currentChar = currentString.charAt(0);

                        // Adds additional 26 to value if the char is uppercase
                        // and adds char position in alphabet
                        if (isUpperCase(currentChar)) {
                            System.out.println("        UP: " + (toLowerCase(currentChar) - 96 + 26));
                            total += toLowerCase(currentChar) - 96;
                            total += 26;
                        } else {
                            System.out.println("        LOW: " + (currentChar - 96));
                            total += currentChar - 96;
                        }
                        break;
                    }
                }
                System.out.println("\n");
            }
            System.out.println("Total: " + total);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}