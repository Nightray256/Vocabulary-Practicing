package nr;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Start chinese test or meaning test? ");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Chinese")) {
            CMeaning cMeaning = new CMeaning();
            cMeaning.run();
        } else if (choice.equalsIgnoreCase("Meaning")) {
            Meaning meaning = new Meaning();
            meaning.run();
        } else {
            System.out.println("Invalid choice");
        }
        scanner.close();
    }
}