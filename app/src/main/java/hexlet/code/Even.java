package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void evenGame() {

        var userName = greeting();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var i = 0;
        while (i < 3) {
            String answer;
            var max = 20;
            var min = 1;
            var range = max - min + 1;
            int randNum = (int)(Math.random() * range) + min;
            if (randNum % 2 == 0) {
                answer = "yes";
            } else {
                answer = "no";
            }

            System.out.print("Question: " + randNum + "\n" +
                    "Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(answer)) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + answer + "'.\n" +
                        "Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }

    public static String greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
