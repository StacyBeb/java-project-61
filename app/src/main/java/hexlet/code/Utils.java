package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomNum(int min, int max) {
        var range = max - min + 1;
        int randNum = (int) (Math.random() * range) + min;

        return randNum;
    }

    public static char getRandomSymbol() {
        String symbols = "+-*";

        Random symbol = new Random();
        char c = symbols.charAt(symbol.nextInt(symbols.length()));

        return c;
    }
}
