package arrays;

import java.util.Objects;

public class MaxSubArray {
    /**
     * Problem: https://leetcode.com/problems/maximum-subarray/
     * Category: Arrays
     * Approach: Brute Force and Kadane's Algorithm
     * difficulty: Medium
     * Time: O(n)
     * Space: O(1)
     */
    public static int solution(int[] nums) {
        int maxSum = nums[0], currentSum = 0;

        for (int num : nums) {
            if (currentSum < 0) { // If current sum is negative, reset it to 0 because negative sums will always decrease the total
                currentSum = 0;
            }
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    /**
     * Time: O(n ^ 2)
     * Space: O(1)
     * Submission Result : Not Accepted, Time Limit Exceeded
     */
    public static int bruteForce(int[] nums) {
        int maxSum = nums[0], currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
            currentSum = 0;
        }
        return maxSum;
    }

    // ---------------------------
    // Self-contained test section
    // ---------------------------
    static void test(String testName, int[] input, int expected) {
        int result = solution(input);
        if (!Objects.equals(result, expected)) {
            System.out.println("❌ " + testName
                    + " | expected=" + expected
                    + " but got=" + result);
        } else {
            System.out.println("✅ " + testName);
        }
    }

    public static void main(String[] args) {
        System.out.println("Running tests...\n");
        test("Example 1", new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6);
        test("Example 2", new int[]{1}, 1);
        test("Example 3", new int[]{5, 4, -1, 7, 8}, 23);
        test("Example 5", new int[]{-1}, -1);
    }
}
