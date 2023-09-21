package Day3_RucksackReorganization;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

// Correct Answer: 8039

public class Day3 {
    public static void main(String[] args) {
        File file = new File("src/rsc/Day3.txt");
        try {
            Scanner scanna = new Scanner(file);

            int total = 0;
            while (scanna.hasNextLine()) {
                String line = scanna.nextLine();

                // Split the line into two halves. (each line is even length)
                String[] firstCompartment = line.substring(0, line.length() / 2).split("");
                String[] secondCompartment = line.substring(line.length() / 2).split("");

                // run through every char in the first half
                for (String currentString : firstCompartment) {
                    char currentChar = currentString.charAt(0);
                    boolean inSecondCompartment = Arrays.asList(secondCompartment).contains(currentString);

                    System.out.println("currentString: " + currentString);
                    System.out.println("    in 2nd: " + inSecondCompartment);

                    // if also in the second -> add alphabet position to total (+26 if capital)
                    if (inSecondCompartment) {
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
/*
String[] compartments = {line.substring(0, line.length()/2),line.substring(line.length()/2)};
 */
