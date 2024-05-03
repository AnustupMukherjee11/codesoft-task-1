import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int rounds, attempts, userGuess, numberToGuess;

        System.out.println("Welcome to the Guess the Number game!");

        do {
            attempts = 0;
            System.out.print("How many rounds would you like to play? ");
            rounds = scanner.nextInt();
            int totalAttempts = 0;

            for (int round = 1; round <= rounds; round++) {
                numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                System.out.println("\nRound " + round + ":");
                System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");

                while (true) {
                    attempts++;
                    System.out.print("Enter your guess: ");
                    userGuess = scanner.nextInt();

                    if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        break;
                    }
                }
            }

            System.out.println("\nGame over! You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
