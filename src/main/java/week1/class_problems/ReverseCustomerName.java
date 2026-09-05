package week1.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) return "";
        char[] chars = customerName.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        String reversed = reverseCustomerName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);

        scanner.close();
    }
}