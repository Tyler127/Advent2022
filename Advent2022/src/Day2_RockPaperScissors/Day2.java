package Day2_RockPaperScissors;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        File file = new File("src/rsc/Day2.txt");
        try {
            Scanner scanna = new Scanner(file);
            HashMap<String, String> winMap = new HashMap<>();
            winMap.put("A", "Y"); winMap.put("B", "Z"); winMap.put("C", "X");
            HashMap<String, String> lossMap = new HashMap<>();
            lossMap.put("A", "Z"); lossMap.put("B", "X"); lossMap.put("C", "Y");
            HashMap<String, String> tieMap = new HashMap<>();
            tieMap.put("A", "X"); tieMap.put("B", "Y"); tieMap.put("C","Z");
            HashMap<String, Integer> scoreMap = new HashMap<>();
            scoreMap.put("X", 1); scoreMap.put("Y", 2); scoreMap.put("Z", 3);

            int totalScore = 0;
            while (scanna.hasNextLine()) {
                String[] lineSplit = scanna.nextLine().split(" ");
                String opponentMove = lineSplit[0];
                String myMove = lineSplit[1];

                /* Part 2: */
                if (Objects.equals(myMove, "Z")) { // need to win
                    myMove = winMap.get(opponentMove);
                }
                else if (Objects.equals(myMove, "X")) { // need to lose
                    myMove = lossMap.get(opponentMove);
                }
                else { // need to draw
                    myMove = tieMap.get(opponentMove);
                }
                /* End Part 2 */

                totalScore += scoreMap.get(myMove);
                if (Objects.equals(winMap.get(opponentMove), myMove)) { // win
                    totalScore += 6;
                }
                else if (Objects.equals(tieMap.get(opponentMove), myMove)) { // tie
                    totalScore += 3;
                }
            }
            System.out.println("Total Score: " + totalScore);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}