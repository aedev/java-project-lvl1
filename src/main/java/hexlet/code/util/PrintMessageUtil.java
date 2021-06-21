package hexlet.code.util;

public final class PrintMessageUtil {

    private PrintMessageUtil() {
    }

    public static void printMessageAnswerIsCorrect() {
        System.out.println("Correct!");
    }

    public static void printMessageAnswerIsWrongAndExit(String userAnswer, String correctAnswer, String name) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
        Runtime.getRuntime().exit(0);
    }

    public static void printCongratulationsMessage(String name) {
        System.out.println("Congratulations, " + name + "!");
    }
}
