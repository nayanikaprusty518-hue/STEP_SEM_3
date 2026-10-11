import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            int num = Integer.parseInt(line);
            
            long factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }
            
            System.out.println(factorial);
        }
        scanner.close();
    }
}