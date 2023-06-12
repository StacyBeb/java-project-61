package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void gcdGame() {

        String[][] rules = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "Find the greatest common divisor of given numbers.";
        for (var row: rules) {
            var roundAnswerAndQuestion = generateRoundData();
            row[0] = roundAnswerAndQuestion[0];
            row[1] = roundAnswerAndQuestion[1];
        }

        Engine.gameLogic(startQuestion, rules);
    }

    public static String[] generateRoundData() {
        int randNum1 = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        int randNum2 = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];
        roundAnswerAndQuestion[0] = randNum1 + " " + randNum2;
        roundAnswerAndQuestion[1] = getAnswer(randNum1, randNum2);

        return roundAnswerAndQuestion;
    }

    public static String getAnswer(int randNum1, int randNum2) {
        String answer = "";
        var del = randNum1;
        while (del > 1) {
            if (randNum1 % del == 0 && randNum2 % del == 0) {
                answer = String.valueOf(del);
                break;
            } else {
                del--;
            }
        }
        if (del == 1) {
            answer = String.valueOf(del);
        }

        return answer;
    }
}
