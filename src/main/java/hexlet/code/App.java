package hexlet.code;

import static hexlet.code.Cli.greetAndGetName;

import hexlet.code.game.CalcGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.Game;
import hexlet.code.game.GcdGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final List<Game> GAME_LIST = List.of(new EvenGame(), new CalcGame(),
        new GcdGame(), new ProgressionGame(), new PrimeGame());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet");
            for (int i = 0; i < GAME_LIST.size(); i++) {
                System.out.println(i + 2 + " - " + GAME_LIST.get(i).getName());
            }
            System.out.println("0 - Exit");

            int gameNumber = scanner.nextInt();

            if (gameNumber == 1) {
                greetAndGetName();
            } else if (gameNumber - 2 >= 0 && gameNumber - 2 < GAME_LIST.size()) {
                GAME_LIST.get(gameNumber - 2).start();
            } else {
                Runtime.getRuntime().exit(0);
            }

        } catch (Exception e) {
            Runtime.getRuntime().exit(0);
        }
    }
}
