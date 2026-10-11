import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            int year = Integer.parseInt(line);
            boolean isLeap = false;
            
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeap = true;
                    }
                } else {
                    isLeap = true;
                }
            }
            
            System.out.println(isLeap ? "Leap year" : "Not a leap year");
        }
        scanner.close();
    }
}