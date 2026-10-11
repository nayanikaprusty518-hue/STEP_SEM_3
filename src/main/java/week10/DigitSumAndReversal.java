import java.util.Scanner;

public class DigitSumAndReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            int num = Integer.parseInt(line);
            int original = num;
            
            int sum = 0;
            int reversed = 0;
            
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                reversed = reversed * 10 + digit;
                num /= 10;
            }
            
            System.out.println("Sum of digits: " + sum);
            System.out.println("Reverse: " + reversed);
        }
        scanner.close();
    }
}