package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void evenGame() {

        String[][] rules = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        for (var i = 0; i < rules.length; i++) {
            rules[i] = generateRoundData();
        }

        Engine.gameLogic(startQuestion, rules);
    }

    public static String[] generateRoundData() {
        int randomNumber = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];
        roundAnswerAndQuestion[0] = String.valueOf(randomNumber);
        roundAnswerAndQuestion[1] = getAnswer(randomNumber);

        System.out.println(roundAnswerAndQuestion);

        return roundAnswerAndQuestion;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0 ? true : false;
    }

    public static String getAnswer(int randomNumber) {
        return isEven(randomNumber) ? "yes" : "no";
    }
}
