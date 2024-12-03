package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void firstSolution() {
        File input = new File("day3_input.txt");

        List<String> matches = new ArrayList<>();
        String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);

        try (Scanner sc = new Scanner(input)) {
            while (sc.hasNextLine()) {
                Matcher matcher = pattern.matcher(sc.nextLine());
                while (matcher.find()) {
                    matches.add(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        long result = 0;
        for (var match : matches) {
            Scanner lc = new Scanner(match);
            while (lc.hasNext()) {
                String next = lc.next();
                int commaIndex = next.indexOf(",");
                int lastParenthesisIndex = next.indexOf(")");
                int firstNum = Integer.parseInt(next.substring(4, commaIndex));
                int secondNum = Integer.parseInt(next.substring(commaIndex + 1, lastParenthesisIndex));
                result += (firstNum * secondNum);
            }
            lc.close();
        }

        System.out.println(result);
    }

    public static void secondSolution() throws FileNotFoundException {
        File inputFile = new File("day3_input.txt");
        Scanner scanner = new Scanner(inputFile);

        String input = scanner.useDelimiter("\\A").next();
        scanner.close();

        Pattern pattern = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do\\(\\))|(don't\\(\\))");
        Matcher matcher = pattern.matcher(input);

        boolean isMulEnabled = true;
        int total = 0;

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                if (isMulEnabled) {
                    int x = Integer.parseInt(matcher.group(2));
                    int y = Integer.parseInt(matcher.group(3));
                    total += x * y;
                }
            } else if (matcher.group(4) != null) {
                isMulEnabled = true;
            } else if (matcher.group(5) != null) {
                isMulEnabled = false;
            }
        }

        System.out.println("Total sum of enabled multiplications: " + total);

    }


    public static void main(String[] args) {
        firstSolution();
        try{
            secondSolution();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
