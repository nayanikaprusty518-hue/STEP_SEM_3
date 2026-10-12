import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;
        
        k = k % n;
        if (k == 0) return names;
        
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + (int) k) % n;
            rotated[newIndex] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }
        long k = scanner.nextLong();
        
        String[] result = rotateRoster(names, k);
        System.out.println(Arrays.toString(result).replace(", ", ", ").replace(" ", ""));
        
        scanner.close();
    }
}