package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "0 - Exit");
        System.out.print("Your choice: ");
        String gameNum = scanner.next();
        switch (gameNum) {
            case "1" -> Cli.askName();
            case "2" -> Even.evenGame();
            case "3" -> Calc.calcGame();
        }
        scanner.close();
    }
}
