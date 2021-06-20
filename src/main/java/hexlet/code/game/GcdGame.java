package hexlet.code.game;

import static hexlet.code.Cli.GreetAndGetName;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class GcdGame implements Game {

    @Override
    public String getName() {
        return "GCD";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String name = GreetAndGetName();
        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 100);
            int number2 = (int) (Math.random() * 100);
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

    private int calcGcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
