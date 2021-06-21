package hexlet.code.games;

import static hexlet.code.Cli.greetAndGetName;
import static hexlet.code.util.PrintMessageUtil.printCongratulationsMessage;
import static hexlet.code.util.PrintMessageUtil.printMessageAnswerIsCorrect;
import static hexlet.code.util.PrintMessageUtil.printMessageAnswerIsWrongAndExit;

import java.util.Random;
import java.util.Scanner;

public final class PrimeGame {

    private static final int MAX_VALUE = 101;
    private static final int NUMBER_OF_ROUNDS = 3;

    private PrimeGame() {
    }

    public static void start() {
        String name = greetAndGetName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        try (Scanner scanner = new Scanner(System.in)) {

            Random random = new Random();

            for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
                int number = random.nextInt(MAX_VALUE);

                System.out.println("Question: " + number);

                String answer = scanner.next();
                boolean isPrime = isPrime(number);
                if (answer.equals("yes") && isPrime || answer.equals("no") && !isPrime) {
                    printMessageAnswerIsCorrect();
                } else {
                    printMessageAnswerIsWrongAndExit(answer, answer.equals("yes") ? "no" : "yes", name);
                }
            }
            printCongratulationsMessage(name);
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
