package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static void gameLogic(String startQuestion, String[] answer, String[] question) {

        var userName = greeting();

        Scanner scanner = new Scanner(System.in);
        System.out.println(startQuestion);
        var i = 0;
        while (i < 3) {
            System.out.print("Question: " + question[i] + "\n" +
                    "Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(answer[i])) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + answer[i] + "'.\n" +
                        "Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }

    private static String greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    public static int getRandomNum() {
        var max = 100;
        var min = 1;
        var range = max - min + 1;
        int randNum = (int)(Math.random() * range) + min;

        return randNum;
    }

    public static char getRandomSymbol() {
        String symbols = "+-*";

        Random symbol = new Random();
        char c = symbols.charAt(symbol.nextInt(symbols.length()));

        return c;
    }
}