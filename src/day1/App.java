package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void firstSolution() {
        File input = new File("day1_input.txt");
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();

        try (Scanner sc = new Scanner(input)) {
            while (sc.hasNextLine()) {
                Scanner lc = new Scanner(sc.nextLine());
                if (lc.hasNextInt()) {
                    leftSide.add(lc.nextInt());
                }
                if (lc.hasNextInt()) {
                    rightSide.add(lc.nextInt());
                }
                lc.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(leftSide);
        Collections.sort(rightSide);

        int difference = 0;
        for (int i = 0; i < leftSide.size(); i++){
            int lItem = leftSide.get(i);
            int rItem = rightSide.get(i);
            if (lItem < rItem){
                difference += (rItem - lItem);
            } else {
                difference += (lItem - rItem);
            }
        }
        System.out.println(difference);
    }

    public static void secondSolution(){
        File input = new File("day1_input.txt");
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();

        try (Scanner sc = new Scanner(input)) {
            while (sc.hasNextLine()) {
                Scanner lc = new Scanner(sc.nextLine());
                if (lc.hasNextInt()) {
                    leftSide.add(lc.nextInt());
                }
                if (lc.hasNextInt()) {
                    rightSide.add(lc.nextInt());
                }
                lc.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        long similarityScore = 0;
        Set<Integer> filteredLeftSide = new LinkedHashSet<>(leftSide);
        for (var num : filteredLeftSide){
            int count = Collections.frequency(rightSide, num);
            similarityScore += (num * count);
        }
        System.out.println(similarityScore);
    }

    public static void main(String[] args) {
        firstSolution();
        secondSolution();

    }
}
