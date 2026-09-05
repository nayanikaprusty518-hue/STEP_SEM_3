package week3.assignment_problems;

public class VotingEligibilityChecker {
    public static void checkVotingEligibility(int age) {
        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        checkVotingEligibility(20);
        System.out.print("Test 2: ");
        checkVotingEligibility(16);
    }
}