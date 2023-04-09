package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "0 - Exit");
        System.out.print("Your choice: ");
        String gameNum = scanner.next();
        if (gameNum.equals("1")) {
            Cli.askName();
        } else if (gameNum.equals("2")) {
            Even.evenGame();
        }
        scanner.close();
    }
}
