package hexlet.code.game;

import static hexlet.code.Cli.greetAndGetName;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CalcGame implements Game {

    private static final List<String> OPERATIONS = List.of("+", "*", "-");
    private static final int MAX_VALUE = 101;
    private static final int NUMBER_OF_ROUNDS = 3;

    /**
     * Return game name.
     * @return name
     */
    @Override
    public String getName() {
        return "Calc";
    }

    /**
     * Start Game.
     */
    @Override
    public void start() {
        String name = greetAndGetName();
        System.out.println("What is the result of the expression?");

        try (Scanner scanner = new Scanner(System.in)) {

            Random random = new Random();

            for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
                int number1 = random.nextInt(MAX_VALUE);
                int number2 = random.nextInt(MAX_VALUE);
                String operation = OPERATIONS.get(random.nextInt(OPERATIONS.size()));

                System.out.println("Question: " + number1 + " " + operation + " " + number2);
                System.out.print("Your answer: ");

                int answer = scanner.nextInt();

                int result = calcResult(number1, number2, operation);
                if (result == answer) {
                    printMessageAnswerIsCorrect();
                } else {
                    printMessageAnswerIsWrongAndExit(String.valueOf(answer), String.valueOf(result), name);
                }
            }
            printCongratulationsMessage(name);
        }
    }

    private int calcResult(int number1, int number2, String operation) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "*":
                return number1 * number2;
            case "-":
                return number1 - number2;
            default:
                throw new IllegalArgumentException("invalid value");
        }
    }
}
