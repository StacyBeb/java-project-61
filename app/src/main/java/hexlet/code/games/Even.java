package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void evenGame() {
        int i = 0;

        String[][] answerAndQuestion = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        for (var row: answerAndQuestion) {
            var roundAnswerAndQuestion = generateRoundData(i);
            row[i] = roundAnswerAndQuestion[i];
            row[i + 1] = roundAnswerAndQuestion[i + 1];
        }

        Engine.gameLogic(startQuestion, answerAndQuestion);
    }

    public static String[] generateRoundData(int i) {
        int randNum = Utils.getRandomNum(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];
        roundAnswerAndQuestion[i] = String.valueOf(randNum);
        roundAnswerAndQuestion[i + 1] = getAnswer(randNum);

        return roundAnswerAndQuestion;
    }

    public static String getAnswer(int randNum) {
        String answer = "";
        if (randNum % 2 == 0) {
            answer = "yes";
        } else {
            answer = "no";
        }

        return answer;
    }
}
