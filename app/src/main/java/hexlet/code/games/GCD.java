package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void gcdGame() {
        String[] answer = new String[3];
        String[] question = new String[3];
        var startQuestion = "Find the greatest common divisor of given numbers.";
        for (var i = 0; i < 3; i++) {
            int randNum1 = Engine.getRandomNum();
            int randNum2 = Engine.getRandomNum();
            question[i] = randNum1 + " " + randNum2;
            var del = randNum1;
            while (del > 1) {
                if (randNum1 % del == 0 && randNum2 % del == 0) {
                    answer[i] = Integer.toString(del);
                    break;
                } else {
                    del--;
                }
            }
            if (del == 1) {
                answer[i] = Integer.toString(del);
            }
        }

        Engine.gameLogic(startQuestion, answer, question);
    }
}
