import java.util.Scanner;

public class AttendanceSummary {
    public static int[] attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        
        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        
        return new int[]{presentCount, longestStreak};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
        }
        
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
        
        scanner.close();
    }
}