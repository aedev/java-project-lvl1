package hexlet.code;

import static hexlet.code.Cli.GreetAndGetName;

import hexlet.code.game.EvenGame;
import hexlet.code.game.Game;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final List<Game> gameList = List.of(new EvenGame());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int i = 0; i < gameList.size(); i++) {
            System.out.println(i + 2 + " - " + gameList.get(i).getName());
        }

        System.out.println("0 - Exit");
        int gameNumber = scanner.nextInt();

        if (gameNumber == -1) {
            System.exit(0);
        }
        if (gameNumber == 1) {
            GreetAndGetName();
        }

        gameList.get(gameNumber - 2).run();
    }
}
