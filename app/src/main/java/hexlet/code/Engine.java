package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int QUESTION_COUNT = 3;
    public static final int ANSWER_COUNT = 2;
    public static void gameLogic(String startQuestion, String[][] answerAndQuestion) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(startQuestion);
        var i = 0;
        int j = 0;

        while (i < QUESTION_COUNT) {
            System.out.print("Question: " + answerAndQuestion[i][j] + "\n"
                    + "Your answer: ");
            String userAnswer = scanner.next();
            if (!userAnswer.equals(answerAndQuestion[i][j + 1])) {
                System.out.println("'"
                        + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + answerAndQuestion[i][j + 1]
                        + "'.\n"
                        + "Let's try again, " + userName + "!");
                scanner.close();
                return;

            }
            System.out.println("Correct!");
            i++;
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
