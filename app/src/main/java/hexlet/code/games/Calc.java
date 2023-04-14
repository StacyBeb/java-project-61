package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void calcGame() {
        String[] answer = new String[3];
        String[] question = new String[3];
        var startQuestion = "What is the result of the expression?";
        for (var i = 0; i < 3; i++) {
            int randNum1 = Engine.getRandomNum();
            int randNum2 = Engine.getRandomNum();
            char symbol = Engine.getRandomSymbol();
            int answerInt = 0;
            switch (symbol) {
                case '*' -> {
                    answerInt = randNum1 * randNum2;
                }
                case '-' -> {
                    answerInt = randNum1 - randNum2;
                }
                case '+' -> {
                    answerInt = randNum1 + randNum2;
                }
            }
            question[i] = randNum1 + " " + symbol + " " + randNum2;
            answer[i] = String.valueOf(answerInt);
        }

        Engine.gameLogic(startQuestion, answer, question);
    }
}
