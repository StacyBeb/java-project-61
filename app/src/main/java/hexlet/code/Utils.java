package hexlet.code;

public class Utils {
    public static int getRandomNumber(int min, int max) {
        var range = max - min + 1;
        int randNum = (int) (Math.random() * range) + min;

        return randNum;
    }
}
