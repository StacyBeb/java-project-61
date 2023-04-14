package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void primeGame() {
        String[] answer = new String[3];
        String[] question = new String[3];
        var startQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        for (var i = 0; i < 3; i++) {
            int randNum = Engine.getRandomNum();
            question[i] = String.valueOf(randNum);
            var del = randNum - 1;
            while (del > 1) {
                if (randNum % del == 0) {
                    answer[i] = "no";
                    break;
                } else {
                    del--;
                }
            }
            if (del == 1) {
                answer[i] = "yes";
            }
        }

        Engine.gameLogic(startQuestion, answer, question);
    }
}
