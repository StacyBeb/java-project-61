package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void primeGame() {
        final var maxRandomNum = 100;
        final var minRandomNum = 1;
        final var questionCount = 3;

        String[] answer = new String[questionCount];
        String[] question = new String[questionCount];
        var startQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        for (var i = 0; i < questionCount; i++) {
            int randNum = Engine.getRandomNum(minRandomNum, maxRandomNum);
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
