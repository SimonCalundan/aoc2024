package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static boolean isDescending(List<Integer> list) {
        int lowerBound = 1;
        int upperBound = 3;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1)) {
                return false;
            }
            int difference = list.get(i) - list.get(i + 1);
            if (difference < lowerBound || difference > upperBound){
                return false;
            }
        }
        return true;
    }

    public static boolean isAscending(List<Integer> list) {
        int lowerBound = 1;
        int upperBound = 3;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i)){
                return false;
            }
            int difference = list.get(i + 1) - list.get(i);
            if (difference < lowerBound || difference > upperBound){
                return false;
            }
        }
        return true;
    }

    public static boolean isDescendingDampener(List<Integer> list) {
        if (isDescending(list)) {
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tamperedList = new ArrayList<>(list);
            tamperedList.remove(i);
            if (isDescending(tamperedList)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAscendingDampener(List<Integer> list) {
        if (isAscending(list)) {
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tamperedList = new ArrayList<>(list);
            tamperedList.remove(i);
            if (isAscending(tamperedList)) {
                return true;
            }
        }
        return false;
    }

    public static void firstSolution() {
        File input = new File("day2_input.txt");

        int safeCount = 0;
        try (Scanner sc = new Scanner(input)) {
            while (sc.hasNextLine()) {
                List<String> strArr = new ArrayList<>(List.of(sc.nextLine().split(" ")));
                List<Integer> row = strArr.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new));

                if (isAscending(row) || isDescending(row)) {
                    safeCount++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(safeCount);
    }

    public static void secondSolution() {
        File input = new File("day2_input.txt");

        int safeCount = 0;
        try (Scanner sc = new Scanner(input)) {
            while (sc.hasNextLine()) {
                List<String> strArr = new ArrayList<>(List.of(sc.nextLine().split(" ")));
                List<Integer> row = strArr.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new));

                if (isAscendingDampener(row) || isDescendingDampener(row)) {
                    safeCount++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(safeCount);
    }

    public static void main(String[] args) {
        firstSolution();
        secondSolution();
    }
}
