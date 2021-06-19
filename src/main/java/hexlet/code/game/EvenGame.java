package hexlet.code.game;

import static hexlet.code.Cli.GreetAndGetName;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {

    @Override
    public String getName() {
        return "Even";
    }

    @Override
    public void run() {
        String name = GreetAndGetName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
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
