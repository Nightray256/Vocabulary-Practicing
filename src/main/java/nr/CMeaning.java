package nr;

import java.util.*;

public class CMeaning {

    private ArrayList<Question> questions;
    private Scanner scanner;

    public CMeaning() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int correctCount = 0;

        inputWordsAndTranslations();

        Collections.shuffle(questions);

        clearScreen();

        for (Question question : questions) {
            System.out.println("What's the vocabulary of \"" + question.getWord() + "\"?");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(question.getTranslation())) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + question.getTranslation());
            }
        }

        System.out.println("\nTotal correct: " + correctCount + " out of " + questions.size());

        scanner.close();
    }

    private void inputWordsAndTranslations() {
        System.out.println("Enter words and their meanings (e.g., word1 meaning1, word2 meaning2, ...)");
        String input = scanner.nextLine();
        clearScreen();
        String[] entries = input.split(",");
        for (String entry : entries) {
            String[] parts = entry.trim().split("\\s+");
            if (parts.length >= 2) {
                questions.add(new Question(parts[0], parts[1]));
            }
        }

    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static class Question {
        private String word;
        private String translation;

        public Question(String word, String translation) {
            this.word = word;
            this.translation = translation;
        }

        public String getWord() {
            return word;
        }

        public String getTranslation() {
            return translation;
        }
    }
}

// 你好 hello, 忍者 ninja, 還沒 yet, 我 me