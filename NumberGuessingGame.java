import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int min = 1;
            int max = 100;
            int attempts = 0;
            int maxAttempts = 10;
            int targetNumber = random.nextInt(max - min + 1) + min;
            boolean isCorrect = false;

            System.out.println("\nI have generated a random number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !isCorrect) {
                System.out.print("Enter your guess: ");

                // Check if the input is a valid integer
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    isCorrect = true;
                    score += maxAttempts - attempts + 1;  // Score based on remaining attempts
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (!isCorrect && attempts == maxAttempts) {
                    System.out.println("You've used all your attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.println("Current Score: " + score);

            // Ask if the player wants to play again, with input validation
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
                System.out.print("Please enter 'yes' or 'no': ");
                response = scanner.next();
            }
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
