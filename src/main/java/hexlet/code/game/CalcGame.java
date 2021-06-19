package hexlet.code.game;

import static hexlet.code.Cli.GreetAndGetName;

import java.util.List;
import java.util.Scanner;

public class CalcGame implements Game {

    private List<String> operations = List.of("+", "*", "-");

    @Override
    public String getName() {
        return "Calc";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String name = GreetAndGetName();
        System.out.println("What is the result of the expression?");

        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 20);
            int number2 = (int) (Math.random() * 20);
            String operation = operations.get((int) (Math.random() * 3));
            System.out.println("Question: " + number1 + operation + number2);

            int answer = scanner.nextInt();

            int result = 0;
            if (operation.equals("+")) {
                result = number1 + number2;
            } else if (operation.equals("*")) {
                result = number1 * number2;
            } else if (operation.equals("-")) {
                result = number1 - number2;
            }

            if (result == answer) {
                printMessageAnswerIsCorrect();
            } else {
                printMessageAnswerIsWrongAndExit(String.valueOf(answer), String.valueOf(result), name);
            }
        }
        printCongratulationsMessage(name);
    }
}
