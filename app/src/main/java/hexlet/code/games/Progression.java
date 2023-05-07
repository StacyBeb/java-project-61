package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    public static final int MaxRandomNum = 100;
    public static final int MinRandomNum = 1;
    public static final int MaxStep = 7;
    public static final int MaxProgressionLength = 10;
    public static final int MinProgressionLength = 5;
    public static void progressionGame() {
        var i = 0;

        String[][] answerAndQuestion = new String[Engine.QuestionCount][Engine.AnswerCount];
        var startQuestion = "What number is missing in the progression?";
        for (var row: answerAndQuestion) {
            var roundAnswerAndQuestion = generateRoundData(i);
            row[i] = roundAnswerAndQuestion[i];
            row[i + 1] = roundAnswerAndQuestion[i + 1];
        }

        Engine.gameLogic(startQuestion, answerAndQuestion);
    }

    private static String[] getProgression(int progressionLength, int num, int step) {
        String[] progression = new String[progressionLength];
        var i = 0;
        progression[i] = String.valueOf(num);
        while (i < progressionLength - 1) {
            i++;
            num = num + step;
            progression[i] = String.valueOf(num);
        }
        return progression;
    }

    public static String[] generateRoundData(int i) {
        String[] roundAnswerAndQuestion = new String[Engine.AnswerCount];
        int randomProgressionLength = Utils.getRandomNum(MinProgressionLength, MaxProgressionLength);
        int randomStep = Utils.getRandomNum(1, MaxStep);
        int randomNum = Utils.getRandomNum(MinRandomNum, MaxRandomNum);
        int randomHidePosition = Utils.getRandomNum(1, randomProgressionLength);

        var progression = getProgression(randomProgressionLength, randomNum, randomStep);
        while (randomProgressionLength >= 0) {
            if (randomHidePosition == randomProgressionLength) {
                roundAnswerAndQuestion[i + 1] = progression[randomHidePosition - 1];
                progression[randomHidePosition - 1] = "..";
            }
            randomProgressionLength--;
        }
        roundAnswerAndQuestion[i] = Arrays.toString(progression).replace(",", "");
        roundAnswerAndQuestion[i] = roundAnswerAndQuestion[i].replace("[", "");
        roundAnswerAndQuestion[i] = roundAnswerAndQuestion[i].replace("]", "");

        return roundAnswerAndQuestion;
    }
}
