package hexlet.code.games;

import static hexlet.code.Cli.greetAndGetName;
import static hexlet.code.util.PrintMessageUtil.printCongratulationsMessage;
import static hexlet.code.util.PrintMessageUtil.printMessageAnswerIsCorrect;
import static hexlet.code.util.PrintMessageUtil.printMessageAnswerIsWrongAndExit;

import java.util.Random;
import java.util.Scanner;

public final class EvenGame {

    private static final int NUMBER_OF_ROUNDS = 3;

    private EvenGame() {
    }

    public static void start() {
        String name = greetAndGetName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        try (Scanner scanner = new Scanner(System.in)) {

            Random random = new Random();

            for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
                int number = random.nextInt();

                System.out.println("Question: " + number);
                System.out.print("Your answer: ");

                String answer = scanner.next();
                if (number % 2 == 0 && answer.equals("yes") || number % 2 != 0 && answer.equals("no")) {
                    printMessageAnswerIsCorrect();
                } else {
                    printMessageAnswerIsWrongAndExit(answer, answer.equals("yes") ? "no" : "yes", name);
                }
            }
            printCongratulationsMessage(name);
        }
    }
}
