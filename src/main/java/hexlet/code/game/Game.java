package hexlet.code.game;

public interface Game {
    String getName();

    void run();

    default void printMessageAnswerIsCorrect() {
        System.out.println("Correct!");
    }

    default void printMessageAnswerIsWrongAndExit(String userAnswer, String correctAnswer, String name) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
        Runtime.getRuntime().exit(0);
    }

    default void printCongratulationsMessage(String name) {
        System.out.println("Congratulations, " + name + "!");
    }
}
