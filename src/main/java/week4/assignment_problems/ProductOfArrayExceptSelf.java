package week4.assignment_problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Test 1: " + Arrays.toString(productExceptSelf(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Test 2: " + Arrays.toString(productExceptSelf(nums2)));
    }
}