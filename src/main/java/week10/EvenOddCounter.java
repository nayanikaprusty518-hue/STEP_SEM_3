import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String line = scanner.nextLine().trim();
        scanner.close();
        
        line = line.replace("[", "").replace("]", "").replace(" ", "");
        
        if (line.isEmpty()) {
            System.out.println("Even: 0");
            System.out.println("Odd: 0");
            return;
        }
        
        String[] parts = line.split(",");
        int even = 0;
        int odd = 0;
        
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}