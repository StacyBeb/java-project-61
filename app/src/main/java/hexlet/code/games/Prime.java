package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int maxRandomNum = 100;
    public static final int minRandomNum = 1;
    public static void primeGame() {
        int i = 0;

        String[][] answerAndQuestion = new String[Engine.questionCount][Engine.answerCount];
        var startQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        for (var row: answerAndQuestion) {
            var roundAnswerAndQuestion = generateRoundData(i);
            row[i] = roundAnswerAndQuestion[i];
            row[i + 1] = roundAnswerAndQuestion[i + 1];
        }

        Engine.gameLogic(startQuestion, answerAndQuestion);
    }

    public static String[] generateRoundData(int i) {
        int randNum = Utils.getRandomNum(minRandomNum, maxRandomNum);
        String[] roundAnswerAndQuestion = new String[Engine.answerCount];

        roundAnswerAndQuestion[i] = String.valueOf(randNum);
        var del = randNum - 1;
        while (del > 1) {
            if (randNum % del == 0) {
                roundAnswerAndQuestion[i + 1] = "no";
                break;
            } else {
                del--;
            }
        }
        if (del == 1) {
            roundAnswerAndQuestion[i + 1] = "yes";
        }

        return roundAnswerAndQuestion;
    }
}
