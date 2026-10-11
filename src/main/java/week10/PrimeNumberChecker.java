import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            int num = Integer.parseInt(line);
            boolean isPrime = true;
            
            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            System.out.println(num + (isPrime ? " is prime" : " is not prime"));
        }
        scanner.close();
    }
}