import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    
    public static int generateRandomNumber(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int playRound(Scanner scanner) {
        int number = generateRandomNumber(1, 100);
        int attempts = 0;
        int maxAttempts = 10;

        while (attempts < maxAttempts) {
            int guess = getUserGuess(scanner);
            attempts++;

            if (guess < number) {
                System.out.println("Too low!");
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return attempts;
            }
        }

        System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The number was " + number + ".");
        return attempts;
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalAttempts = 0;

        while (true) {
            totalRounds++;
            System.out.println("\nRound " + totalRounds);
            int attempts = playRound(scanner);
            totalAttempts += attempts;

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame over! You played " + totalRounds + " rounds with a total of " + totalAttempts + " attempts.");
        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.println("Your average attempts per round: " + String.format("%.2f", averageAttempts));
    }

    public static void main(String[] args) {
        playGame();
    }
}
