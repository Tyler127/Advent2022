package Day5_SupplyStacks;

import java.io.File;
import java.util.*;

public class Day5Part2CLEAN {
    public static void main(String[] args) {
        File stacksFile = new File("src/rsc/Day5_stacks.txt");
        File movesFile = new File("src/rsc/Day5_moves.txt");
        Scanner scanna;
        ArrayList<Stack<String>> stackArray = new ArrayList<>();
        for(int i = 0; i < 9; i++) stackArray.add(new Stack<>());

        try {
            scanna = new Scanner(stacksFile);

            while (scanna.hasNextLine()) {
                String[] line = scanna.nextLine().split("");
                for (int i = 1; i <= line.length; i+=4) {
                    if (!Objects.equals(line[i], " ")) stackArray.get((int) Math.floor((float) i/4)).push(line[i]);
                }
            }

            for (Stack stack : stackArray) {
                ArrayList<String> holder = new ArrayList<>();
                while (!stack.empty()) holder.add((String) stack.pop());
                for (String string : holder) stack.push(string);
            }
        } catch (Exception e) {e.printStackTrace();}

        try {
            scanna = new Scanner(movesFile);

            while (scanna.hasNextLine()) {
                String line = scanna.nextLine();
                String[] lineSplit = line.split(" ");
                int amountOfMoves = Integer.parseInt(lineSplit[1]);
                int stackToRemoveFrom = Integer.parseInt(lineSplit[3]) - 1;
                int stackToPlaceIn = Integer.parseInt(lineSplit[5]) - 1;

                ArrayList<String> holder = new ArrayList<>();
                for (int i = 0; i < amountOfMoves; i++) holder.add(stackArray.get(stackToRemoveFrom).pop());

                Collections.reverse(holder);
                for (String string : holder) stackArray.get(stackToPlaceIn).push(string);
            }
        } catch (Exception e) {e.printStackTrace();}

        String finalString = "";
        for (Stack stack : stackArray) finalString += stack.pop();
        System.out.println("Stack Tops: " + finalString);
    }
}