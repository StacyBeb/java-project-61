package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void evenGame() {
        var questionCount = 3;
        String[] answer = new String[questionCount];
        String[] question = new String[questionCount];
        var startQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        for (var i = 0; i < questionCount; i++) {
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
