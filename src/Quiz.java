import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Questions> questions;
    private int score;
    private Scanner scanner;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);
        loadQuestions();
    }
    private void loadQuestions() {
                questions.add(new Questions(
                "Which keyword is used to define a constant in Java?",
                List.of("static", "final", "const", "abstract"),
                1
        ));

        questions.add(new Questions(
                "What is the default value of a boolean variable in Java?",
                List.of("true", "false", "0", "null"),
                1
        ));

        questions.add(new Questions(
                "Which of these is not a Java feature?",
                List.of("Object-Oriented", "Use of Pointers", "Portable", "Dynamic"),
                1
        ));

        questions.add(new Questions(
                "What is the entry point of a Java application?",
                List.of("main() method", "start() method", "run() method", "init() method"),
                0
        ));

        questions.add(new Questions(
                "Which concept refers to a mechanism by which a new class is derived from an existing class?",
                List.of("Polymorphism", "Encapsulation", "Inheritance", "Abstraction"),
                2
        ));

        questions.add(new Questions(
                "Which of the following is a checked exception in Java?",
                List.of("NullPointerException", "ArrayIndexOutOfBoundsException", "IOException", "ArithmeticException"),
                2
        ));

        questions.add(new Questions(
                "What is 'JVM' stand for?",
                List.of("Java Visual Machine", "Java Virtual Method", "Java Virtual Machine", "Java Very Mobile"),
                2
        ));

        questions.add(new Questions(
                "Which collection class allows you to store unique elements in a sorted manner?",
                List.of("ArrayList", "HashSet", "TreeSet", "LinkedList"),
                2
        ));

        questions.add(new Questions(
                "Which access modifier makes a member accessible only within its own class?",
                List.of("public", "protected", "default (no modifier)", "private"),
                3
        ));

        questions.add(new Questions(
                "What does 'JRE' stand for?",
                List.of("Java Runtime Environment", "Java Resource Editor", "Java Realtime Engine", "Java Remote Execution"),
                0
        ));
    }
    public void startQuiz() {
        System.out.println("--- Welcome to the Online Quiz! ---");
        for (int i = 0; i < questions.size(); i++) {
            Questions currentQuestions = questions.get(i);
            currentQuestions.displayQuestion();

            int userAnswer = -1;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter your answer (1-" + currentQuestions.getOptions().size() + "): ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= currentQuestions.getOptions().size()) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter a number within the given range.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                }
            }

            if (currentQuestions.isCorrect(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " +
                        currentQuestions.getOptions().get(currentQuestions.getCorrectAnswerIndex()));
            }
        }
        displayResults();
    }
    private void displayResults() {
        System.out.println("\n--- Quiz Finished! ---");
        System.out.println("You scored " + score + " out of " + questions.size() + " questions.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}
