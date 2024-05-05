package nr;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Basic {

    private ArrayList<String> words;
    private Random random;
    private Scanner scanner;

    public Basic() {
        words = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int correctCount = 0;

        while (words.size() < 5) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();
            words.add(word);
        }

        for (String word : words) {
            String sentence = generateSentence(word);
            String hiddenWord = hideLetters(sentence);
            System.out.println("Answer the word: " + sentence);
            System.out.print("Your answer: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(hiddenWord)) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + hiddenWord);
            }
        }
        System.out.println ("\nTotal correct" + correctCount + " out of 4");
        scanner.close();
    }

    private String generateSentence(String word) {
        String verb = isVerb(word) ? word + "ed" : word;
        return "The " + word + " is " + verb + " now.";
    }

    private boolean isVerb(String word) {
        return word.endsWith("e");
    }

    private String hideLetters(String word) {
        int length = word.length();
        if (length <= 2) {
            return word;
        }
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(length - 1);
        StringBuilder hiddenWord = new StringBuilder();
        hiddenWord.append(firstChar);
        for (int i = 1; i < length - 1; i++) {
            hiddenWord.append("*");
        }
        hiddenWord.append(lastChar);
        return hiddenWord.toString();
    }
}
