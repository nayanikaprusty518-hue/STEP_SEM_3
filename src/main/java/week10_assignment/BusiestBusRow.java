import java.util.Scanner;

public class BusiestBusRow {
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;
        
        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRow = i;
            }
        }
        
        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
        
        scanner.close();
    }
}