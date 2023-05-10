package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int QUESTION_COUNT = 3;
    public static final int ANSWER_COUNT = 2;
    public static void gameLogic(String startQuestion, String[][] rules) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(startQuestion);

        for (String[] rule: rules) {
            System.out.println("Question: " + rule[0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (!userAnswer.equals(rule[1])) {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + rule[1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;

            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
