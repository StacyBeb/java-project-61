package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static final int MAX_STEP = 7;
    public static final int MAX_PROGRESSION_LENGTH = 10;
    public static final int MIN_PROGRESSION_LENGTH = 5;
    public static void progressionGame() {
        var i = 0;

        String[][] answerAndQuestion = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
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
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];
        int randomProgressionLength = Utils.getRandomNum(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int randomStep = Utils.getRandomNum(1, MAX_STEP);
        int randomNum = Utils.getRandomNum(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
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
