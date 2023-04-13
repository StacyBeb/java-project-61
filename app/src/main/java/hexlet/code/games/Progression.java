package hexlet.code.games;

import hexlet.code.Engine;
public class Progression {
    public static void progressionGame() {
        String[] answer = new String[3];
        String[] question = new String[3];
        var startQuestion = "What number is missing in the progression?";
        for (var i = 0; i < 3; i++) {
            int randomProgressionLength = Engine.getRandomNum(5, 10);
            int randomStep = Engine.getRandomNum(1, 7);
            int randomNum = Engine.getRandomNum();
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
