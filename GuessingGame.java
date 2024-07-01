package GuessingGame;


import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("\nWelcome to the Number Guessing Game!\n");

        while (playAgain) {
            int generatedNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("Instructions:");
            System.out.println("- You have to guess the number generated between 1 to 100.");
            System.out.println("- You have 5 attempts to guess the correct number.");
            System.out.println("- After each guess, you will be informed if your guess is too high or too low.\n");

            System.out.println("Round " + (roundsWon + 1) + ":");

            boolean guessedCorrectly = false;
            while (attempts < 5) {
                System.out.print("Guess the number (1-100): ");
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.next(); // Clear the invalid input
                    continue;
                }
                int guess = sc.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("Out of range. Please enter a number between 1 and 100.");
                    continue;
                }
                attempts++;

                if (guess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    roundsWon++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < generatedNumber) {
                    System.out.println("Too low. The number is greater than " + guess + ".\nAttempts left: " + (5 - attempts));
                } else {
                    System.out.println("Too high. The number is less than " + guess + ".\nAttempts left: " + (5 - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the correct number. The correct number was: " + generatedNumber);
            }

            System.out.println("\nScore: " + roundsWon + " round(s) won.\n");

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = sc.next();
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            } else {
                System.out.println(); // Blank line for better readability
            }
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Total Rounds Won: " + roundsWon);
        sc.close();
    }
}
