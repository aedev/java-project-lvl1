package hexlet.code.game;

import static hexlet.code.Cli.GreetAndGetName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgressionGame implements Game {

    @Override
    public String getName() {
        return "Progression";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String name = GreetAndGetName();
        System.out.println("What number is missing in the progression?");

        for (int i = 0; i < 3; i++) {
            int start = (int) (Math.random() * 100);
            int difference = (int) (Math.random() * 100);
            int sequenceSize = (int) (Math.random() * 6) + 5;
            int maskCount = (int) (Math.random() * sequenceSize);

            List<Integer> sequence = new ArrayList<>();
            sequence.add(start);

            int previous = start;
            for (int j = 0; j < sequenceSize; j++) {
                previous += difference;
                sequence.add(previous);
            }

            System.out.println("Question: " + printSequence(sequence, maskCount));
            System.out.print("Your answer: ");

            int answer = scanner.nextInt();

            if (sequence.get(maskCount) == answer) {
                printMessageAnswerIsCorrect();
            } else {
                printMessageAnswerIsWrongAndExit(String.valueOf(answer), sequence.get(maskCount).toString(), name);
            }
        }
        printCongratulationsMessage(name);
    }

    private String printSequence(List<Integer> sequence, int maskCount) {
        String result = "";
        for (int i = 0; i < sequence.size(); i++) {
            result += " ";
            if (i == maskCount) {
                result += "..";
                continue;
            }
            result += sequence.get(i);
        }
        return result;
    }
}
