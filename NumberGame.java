import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int roundsWon = 0;
        int totalScore = 0;
        String playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int number = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    guessedCorrectly = true;

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;
                    roundsWon++;

                    System.out.println("Attempts Taken: " + attempts);
                    System.out.println("Score for this round: " + score);
                    break;
                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Remaining Attempts: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ Game Over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\n----- Current Statistics -----");
            System.out.println("Rounds Won: " + roundsWon);
            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n===== FINAL RESULT =====");
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}