package hexlet.code.games;

import static hexlet.code.Cli.greetAndGetName;
import static hexlet.code.util.PrintMessageUtil.printCongratulationsMessage;
import static hexlet.code.util.PrintMessageUtil.printMessageAnswerIsCorrect;
import static hexlet.code.util.PrintMessageUtil.printMessageAnswerIsWrongAndExit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class ProgressionGame {

    private static final int MAX_VALUE = 101;
    private static final int MAX = 10;
    private static final int MIN = 5;
    private static final int NUMBER_OF_ROUNDS = 3;
    private static final String MASK = "..";
    private static final String SPACE = " ";

    private ProgressionGame() {
    }

    public static void start() {
        String name = greetAndGetName();
        System.out.println("What number is missing in the progression?");

        try (Scanner scanner = new Scanner(System.in)) {

            Random random = new Random();

            for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
                int startSequence = random.nextInt(MAX_VALUE);
                int stepSequence = random.nextInt(MAX_VALUE);
                int sequenceSize = random.nextInt((MAX - MIN) + 1) + MIN;
                int maskIndexNumber = random.nextInt(sequenceSize + 1);

                List<Integer> sequence = makeSequence(startSequence, stepSequence, sequenceSize);

                System.out.println("Question:" + printSequence(sequence, maskIndexNumber));
                System.out.print("Your answer: ");

                int answer = scanner.nextInt();
                if (sequence.get(maskIndexNumber) == answer) {
                    printMessageAnswerIsCorrect();
                } else {
                    String correctAnswer = sequence.get(maskIndexNumber).toString();
                    printMessageAnswerIsWrongAndExit(String.valueOf(answer), correctAnswer, name);
                }
            }
            printCongratulationsMessage(name);
        }
    }

    private static List<Integer> makeSequence(int start, int step, int size) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(start);

        int previous = start;
        for (int j = 0; j < size; j++) {
            previous += step;
            sequence.add(previous);
        }
        return sequence;
    }

    private static String printSequence(List<Integer> sequence, int maskCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sequence.size(); i++) {
            result.append(SPACE);
            if (i == maskCount) {
                result.append(MASK);
                continue;
            }
            result.append(sequence.get(i));
        }
        return result.toString();
    }
}
