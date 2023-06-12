package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static final int MAX_STEP = 7;
    public static final int MAX_PROGRESSION_LENGTH = 10;
    public static final int MIN_PROGRESSION_LENGTH = 5;
    public static void progressionGame() {

        String[][] rules = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "What number is missing in the progression?";
        for (var i = 0; i < rules.length; i++) {
            rules[i] = generateRoundData();
        }

        Engine.gameLogic(startQuestion, rules);
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

    public static String[] generateRoundData() {
        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];
        int randomProgressionLength = Utils.getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int randomStep = Utils.getRandomNumber(1, MAX_STEP);
        int randomNumber = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        int randomHidePosition = Utils.getRandomNumber(0, randomProgressionLength - 1);

        var progression = getProgression(randomProgressionLength, randomNumber, randomStep);

        roundAnswerAndQuestion[1] = progression[randomHidePosition];
        progression[randomHidePosition] = "..";
        roundAnswerAndQuestion[0] = String.join(" ", progression);

        return roundAnswerAndQuestion;
    }
}
