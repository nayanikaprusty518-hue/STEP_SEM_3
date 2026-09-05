package week3.assignment_problems;

public class GuessTheNumberGame {
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tryCounter = 0;
        
        while (tryCounter < maxTries && tryCounter < guesses.length) {
            int guess = guesses[tryCounter];
            
            if (guess < secretNumber) {
                System.out.println("Too low");
            } else if (guess > secretNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Correct! You guessed it");
                return;
            }
            tryCounter++;
        }
        
        System.out.println("Out of tries — the number was " + secretNumber);
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        guessTheNumber(42, 4, new int[]{20, 60, 42});
        System.out.println("Test 2:");
        guessTheNumber(42, 2, new int[]{10, 15});
    }
}