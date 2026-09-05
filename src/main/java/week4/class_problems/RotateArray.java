package week4.class_problems;

import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        k = k % n;

        if (k == 0) {
            return nums;
        }

        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] result1 = rotateArray(nums1, k1);
        System.out.println("Test 1: " + Arrays.toString(result1));

        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] result2 = rotateArray(nums2, k2);
        System.out.println("Test 2: " + Arrays.toString(result2));
    }
}