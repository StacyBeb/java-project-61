package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void evenGame() {
        String[] answer = new String[3];
        String[] question = new String[3];
        var startQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        for (var i = 0; i < 3; i++) {
            int randNum = Engine.getRandomNum();
            question[i] = String.valueOf(randNum);
            if (randNum % 2 == 0) {
                answer[i] = "yes";
            } else {
                answer[i] = "no";
            }
        }

        Engine.gameLogic(startQuestion, answer, question);
    }
}
