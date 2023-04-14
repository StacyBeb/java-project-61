package hexlet.code.games;

import hexlet.code.Engine;
public class Progression {
    public static void progressionGame() {
        final var maxRandomNum = 100;
        final var minRandomNum = 1;
        final var maxStep = 7;
        final var maxProgressionLength = 10;
        final var minProgressionLength = 5;
        final var questionCount = 3;

        String[] answer = new String[questionCount];
        String[] question = new String[questionCount];
        var startQuestion = "What number is missing in the progression?";
        for (var i = 0; i < questionCount; i++) {
            int randomProgressionLength = Engine.getRandomNum(minProgressionLength, maxProgressionLength);
            int randomStep = Engine.getRandomNum(1, maxStep);
            int randomNum = Engine.getRandomNum(minRandomNum, maxRandomNum);
            int randomHidePosition = Engine.getRandomNum(1, randomProgressionLength);
            question[i] = String.valueOf(randomNum);
            while (randomProgressionLength >= 0) {
                randomNum = randomNum + randomStep;
                if (randomHidePosition == randomProgressionLength) {
                    answer[i] = String.valueOf(randomNum);
                    question[i] = question[i] + " ..";
                } else {
                    question[i] = question[i] + " " + randomNum;
                }
                randomProgressionLength--;
            }
        }

        Engine.gameLogic(startQuestion, answer, question);
    }
}
