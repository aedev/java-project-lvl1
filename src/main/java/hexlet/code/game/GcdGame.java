package hexlet.code.game;

import static hexlet.code.Cli.greetAndGetName;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class GcdGame implements Game {

    private static final int MAX_VALUE = 101;
    private static final int NUMBER_OF_ROUNDS = 3;

    /**
     * Return game name.
     * @return name
     */
    @Override
    public String getName() {
        return "GCD";
    }

    /**
     * Start Game.
     */
    @Override
    public void start() {
        String name = greetAndGetName();
        System.out.println("Find the greatest common divisor of given numbers.");

        try (Scanner scanner = new Scanner(System.in)) {

            Random random = new Random();

            for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
                int number1 = random.nextInt(MAX_VALUE);
                int number2 = random.nextInt(MAX_VALUE);

                System.out.println("Question: " + number1 + " " + number2);
                System.out.print("Your answer: ");

                int answer = scanner.nextInt();
                int result = calcGcd(number1, number2);
                if (result == answer) {
                    printMessageAnswerIsCorrect();
                } else {
                    printMessageAnswerIsWrongAndExit(String.valueOf(answer), String.valueOf(result), name);
                }
            }
            printCongratulationsMessage(name);
        }
    }

    private int calcGcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
