package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    public static final int MAX_RANDOM_NUM = 100;
    public static final int MIN_RANDOM_NUM = 1;
    public static void calcGame() {
        var i = 0;

        String[][] answerAndQuestion = new String[Engine.QUESTION_COUNT][Engine.ANSWER_COUNT];
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
        int randNum1 = Utils.getRandomNum(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        int randNum2 = Utils.getRandomNum(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        char symbol = getRandomSymbol();

        String[] roundAnswerAndQuestion = new String[Engine.ANSWER_COUNT];

        roundAnswerAndQuestion[i] = randNum1 + " " + symbol + " " + randNum2;
        roundAnswerAndQuestion[i + 1] = getAnswer(randNum1, randNum2, symbol);
        return roundAnswerAndQuestion;
    }

    public static String getAnswer(int randNum1, int randNum2, char symbol) {
        String answer = "";

        switch (symbol) {
            case '*' -> {
                answer = String.valueOf(randNum1 * randNum2);
            }
            case '-' -> {
                answer = String.valueOf(randNum1 - randNum2);
            }
            case '+' -> {
                answer = String.valueOf(randNum1 + randNum2);
            }
            default -> {
                break;
            }
        }

        return answer;
    }
}
