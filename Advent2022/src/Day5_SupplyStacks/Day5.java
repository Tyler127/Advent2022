package Day5_SupplyStacks;

import java.io.File;
import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        File stacksFile = new File("src/rsc/Day5_stacks.txt");
        File movesFile = new File("src/rsc/Day5_moves.txt");
        Scanner scanna;

        // Create an Array of 9 empty stack objects
        ArrayList<Stack<String>> stackArray = new ArrayList<>();
        for(int i = 0; i < 9; i++) stackArray.add(new Stack<>());

        // Add the letter strings to the stacks in stackArray
        try {
            scanna = new Scanner(stacksFile);

            while (scanna.hasNextLine()) {
                String[] line = scanna.nextLine().split("");

                // Each letter will occur exactly every 4 spaces + 1 from the [ on the far left
                // so start i and 1 and increment i by 4 until the length of the line is reached
                for (int i = 1; i <= line.length; i+=4) {
                    // Only add to the stack if the line is actually a letter
                    if (!Objects.equals(line[i], " ")) {
                        // letters occur every 4 indexes so converting to the stack it does in
                        // divide by 4 and then floor
                        int stackIndex = (int) Math.floor(i/4);
                        stackArray.get(stackIndex).push(line[i]);
                    }
                }
            }

            // Reverse the order of the stacks (bc started adding from the top not bottom)
            for (Stack stack : stackArray) {
                ArrayList<String> holder = new ArrayList<>();
                while (!stack.empty()) {
                    holder.add((String) stack.pop());
                }
                for (String string : holder) {
                    stack.push(string);
                }
            }

        } catch (Exception e) {e.printStackTrace();}

        // Move items among the stacks
        try {
            scanna = new Scanner(movesFile);

            while (scanna.hasNextLine()) {
                String line = scanna.nextLine();
                String[] lineSplit = line.split(" ");

                int amountOfMoves = Integer.parseInt(lineSplit[1]);
                // Remove one from the stack ints because they must be indexed from zero (refer to array pos)
                int stackToRemoveFrom = Integer.parseInt(lineSplit[3]) - 1;
                int stackToPlaceIn = Integer.parseInt(lineSplit[5]) - 1;

                // move items from stack a to stack b for the amount of moves
                for (int i = 0; i < amountOfMoves; i++) {
                    stackArray.get(stackToPlaceIn).push(stackArray.get(stackToRemoveFrom).pop());
                }
            }
        } catch (Exception e) {e.printStackTrace();}

        String finalString = "";
        for (Stack stack : stackArray) {
            finalString += stack.pop();
        }
        System.out.println("Stack Tops: " + finalString);
    }
}