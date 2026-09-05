package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random random = new Random();

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 5;
        String[][] roundTable = new String[rounds][4];
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Rock-Paper-Scissors Game - " + rounds + " Rounds");
        System.out.println("Enter your move (Rock, Paper, or Scissors):");

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Player: ");
            String playerMove = scanner.nextLine().trim();
            while (!isValidMove(playerMove)) {
                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine().trim();
            }

            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);

            roundTable[i][0] = String.valueOf(i + 1);
            roundTable[i][1] = capitalize(playerMove);
            roundTable[i][2] = computerMove;
            roundTable[i][3] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("  Computer: " + computerMove + " -> " + result);
        }

        printSummary(roundTable, wins, losses, draws, rounds);
        scanner.close();
    }

    private static boolean isValidMove(String move) {
        for (String m : MOVES) {
            if (m.equalsIgnoreCase(move)) return true;
        }
        return false;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    private static void printSummary(String[][] table, int wins, int losses, int draws, int total) {
        System.out.println("\nFinal Summary:");
        System.out.printf("%-8s %-15s %-15s %s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------");
        for (String[] row : table) {
            System.out.printf("%-8s %-15s %-15s %s%n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("------------------------------------------------------------");
        double winPercent = total > 0 ? (wins * 100.0 / total) : 0;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercent);
    }
}