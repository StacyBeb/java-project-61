package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void primeGame() {

        String[][] rules = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        for (var i = 0; i < rules.length; i++) {
            rules[i] = generateRoundData();
        }

        Engine.gameLogic(startQuestion, rules);
    }

    public static String[] generateRoundData() {
        int randNum = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];

        roundAnswerAndQuestion[0] = String.valueOf(randNum);
        roundAnswerAndQuestion[1] = getAnswer(randNum);

        return roundAnswerAndQuestion;
    }

    public static boolean isPrime(int num) {
        var del = num - 1;
        while (del > 1) {
            if (num % del == 0) {
                return false;
            } else {
                del--;
            }
        }
        return true;
    }

    public static String getAnswer(int randNum) {
        return isPrime(randNum) ? "yes" : "no";
    }
}
