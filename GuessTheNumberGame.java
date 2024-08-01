import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            boolean guessedCorrectly = false;
            int attempts = 0;

            System.out.println("Welcome to Guess the Number!");
            System.out.println("I'm thinking of a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) {
                    System.out.println("Your guess is out of range. Please guess between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number correctly.");
                }

                if (!guessedCorrectly && attempts == MAX_ATTEMPTS) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
                }
            }

            if (guessedCorrectly) {
                roundsWon++;
            }

            System.out.println("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Clear the buffer
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Game Over!");
        System.out.println("You played " + totalRounds + " rounds and won " + roundsWon + " rounds.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
