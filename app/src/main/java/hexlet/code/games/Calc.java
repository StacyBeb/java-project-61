package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void calcGame() {

        String[][] rules = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
        var startQuestion = "What is the result of the expression?";
        for (var i = 0; i < rules.length; i++) {
            rules[i] = generateRoundData();
        }

        Engine.gameLogic(startQuestion, rules);
    }

    public static String[] generateRoundData() {
        int randomNumber1 = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        int randomNumber2 = Utils.getRandomNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        char symbol = getRandomSymbol();

        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];

        roundAnswerAndQuestion[0] = randomNumber1 + " " + symbol + " " + randomNumber2;
        roundAnswerAndQuestion[1] = getAnswer(randomNumber1, randomNumber2, symbol);
        return roundAnswerAndQuestion;
    }

    public static String getAnswer(int randomNumber1, int randomNumber2, char symbol) {
        String answer = "";

        return switch (symbol) {
            case '*' -> String.valueOf(randomNumber1 * randomNumber2);
            case '-' -> String.valueOf(randomNumber1 - randomNumber2);
            case '+' -> String.valueOf(randomNumber1 + randomNumber2);
            default ->
                throw new Error("Unknown symbol: " + symbol + "!");
        };
    }

    public static char getRandomSymbol() {
        String symbols = "+-*";

        char c = symbols.charAt(Utils.getRandomNumber(0, symbols.length() - 1));

        return c;
    }
}
