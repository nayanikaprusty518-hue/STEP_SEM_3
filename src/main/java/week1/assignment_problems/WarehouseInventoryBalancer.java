package week1.assignment_problems;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Error: Arrays cannot be null");
            return;
        }
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Arrays must have equal length");
            return;
        }

        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highestQty = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + 
            " | Status: " + status + " | Highest Quantity: " + highestQty + 
            " (" + highestSection + ", Item " + highestIndex + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        System.out.print("Test 1: ");
        analyzeInventory(sectionA, sectionB);
    }
}