package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void gcdGame() {
        var questionCount = 3;
        String[] answer = new String[questionCount];
        String[] question = new String[questionCount];
        var startQuestion = "Find the greatest common divisor of given numbers.";
        for (var i = 0; i < questionCount; i++) {
            int randNum1 = Engine.getRandomNum();
            int randNum2 = Engine.getRandomNum();
            question[i] = randNum1 + " " + randNum2;
            var del = randNum1;
            while (del > 1) {
                if (randNum1 % del == 0 && randNum2 % del == 0) {
                    answer[i] = String.valueOf(del);
                    break;
                } else {
                    del--;
                }
            }
            if (del == 1) {
                answer[i] = String.valueOf(del);
            }
        }

        Engine.gameLogic(startQuestion, answer, question);
    }
}
