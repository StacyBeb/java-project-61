package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    public static final int maxRandomNum = 100;
    public static final int minRandomNum = 1;
    public static void calcGame() {
        var i = 0;

        String[][] answerAndQuestion = new String[Engine.questionCount][Engine.answerCount];
        var startQuestion = "What is the result of the expression?";
        for (var row: answerAndQuestion) {
            var roundAnswerAndQuestion = generateRoundData(i);
            row[i] = roundAnswerAndQuestion[i];
            row[i + 1] = roundAnswerAndQuestion[i + 1];
        }

        Engine.gameLogic(startQuestion, answerAndQuestion);
    }

    public static char getRandomSymbol() {
        String symbols = "+-*";

        Random symbol = new Random();
        char c = symbols.charAt(symbol.nextInt(symbols.length()));

        return c;
    }

    public static String[] generateRoundData(int i) {
        int randNum1 = Utils.getRandomNum(minRandomNum, maxRandomNum);
        int randNum2 = Utils.getRandomNum(minRandomNum, maxRandomNum);
        char symbol = getRandomSymbol();
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
            default -> {
                break;
            }
        }
        String[] roundAnswerAndQuestion = new String[Engine.answerCount];

        roundAnswerAndQuestion[i] = randNum1 + " " + symbol + " " + randNum2;
        roundAnswerAndQuestion[i + 1] = String.valueOf(answerInt);
        return roundAnswerAndQuestion;
    }
}
