package week3.assignment_problems;

public class PrimeNumberCheckerLevel2 {
    public static void checkPrime(int number) {
        if (number <= 1) {
            System.out.println("Not Prime");
            return;
        }
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Prime" : "Not Prime");
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        checkPrime(17);
        System.out.print("Test 2: ");
        checkPrime(18);
    }
}