package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void evenGame() {

        String[][] rules = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        for (var row: rules) {
            row[0] = generateRoundData()[0];
            row[1] = generateRoundData()[1];
        }

        Engine.gameLogic(startQuestion, rules);
    }

    public static String[] generateRoundData() {
        int randNum = Utils.getRandomNum(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];
        roundAnswerAndQuestion[0] = String.valueOf(randNum);
        roundAnswerAndQuestion[1] = getAnswer(randNum);

        return roundAnswerAndQuestion;
    }

    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getAnswer(int randNum) {
        String answer = "";
        if (isEven(randNum)) {
            answer = "yes";
        } else {
            answer = "no";
        }

        return answer;
    }
}
