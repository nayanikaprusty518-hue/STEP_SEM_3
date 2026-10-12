import java.util.Scanner;

public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int firstGeLow = lowerBound(scores, low);
        int firstGtHigh = upperBound(scores, high);
        return firstGtHigh - firstGeLow;
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        
        int result = countInBand(scores, low, high);
        System.out.println(result);
        
        scanner.close();
    }
}