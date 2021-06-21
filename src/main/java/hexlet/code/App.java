package hexlet.code;

import static hexlet.code.Cli.greetAndGetName;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import java.util.Scanner;

public class App {

    private static final int EXIT_MENU_ITEM = 0;
    private static final int GREAT_MENU_ITEM = 1;
    private static final int EVEN_GAME_MENU_ITEM = 2;
    private static final int CALC_GAME_MENU_ITEM = 3;
    private static final int GCD_GAME_MENU_ITEM = 4;
    private static final int PROGRESSION_GAME_MENU_ITEM = 5;
    private static final int PRIME_GAME_MENU_ITEM = 6;

    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");

        try (Scanner scanner = new Scanner(System.in)) {

            int gameNumber = scanner.nextInt();

            switch (gameNumber) {
                case GREAT_MENU_ITEM:
                    greetAndGetName();
                    break;
                case EVEN_GAME_MENU_ITEM:
                    EvenGame.start();
                    break;
                case CALC_GAME_MENU_ITEM:
                    CalcGame.start();
                    break;
                case GCD_GAME_MENU_ITEM:
                    GcdGame.start();
                    break;
                case PROGRESSION_GAME_MENU_ITEM:
                    ProgressionGame.start();
                    break;
                case PRIME_GAME_MENU_ITEM:
                    PrimeGame.start();
                    break;
                case EXIT_MENU_ITEM:
                default:
                    Runtime.getRuntime().exit(0);
            }
        }
    }
}
