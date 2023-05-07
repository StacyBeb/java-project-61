package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final int maxRandomNum = 100;
    public static final int minRandomNum = 1;
    public static void gcdGame() {
        int i = 0;

        String[][] answerAndQuestion = new String[Engine.questionCount][Engine.answerCount];
        var startQuestion = "Find the greatest common divisor of given numbers.";
        for (var row: answerAndQuestion) {
            var roundAnswerAndQuestion = generateRoundData(i);
            row[i] = roundAnswerAndQuestion[i];
            row[i + 1] = roundAnswerAndQuestion[i + 1];
        }

        Engine.gameLogic(startQuestion, answerAndQuestion);
    }

    public static String[] generateRoundData(int i) {
        int randNum1 = Utils.getRandomNum(minRandomNum, maxRandomNum);
        int randNum2 = Utils.getRandomNum(minRandomNum, maxRandomNum);
        String[] roundAnswerAndQuestion = new String[Engine.answerCount];
        roundAnswerAndQuestion[i] = randNum1 + " " + randNum2;
        roundAnswerAndQuestion[i + 1] = getAnswer(randNum1, randNum2);

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
