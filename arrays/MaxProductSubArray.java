package arrays;

import java.util.Objects;

public class MaxProductSubArray {
    /**
     * Problem: https://leetcode.com/problems/maximum-subarray/
     * Category: Arrays
     * Approach: Brute Force and Dynamic Programming
     * difficulty: Medium
     * Time: O(n)
     * Space: O(1)
     */
    public static int solution(int[] nums) {
        int maxProd = nums[0], currMax = 1, currMin = 1;
        for (int num : nums) {
            int temp = currMax * num; // Store current max * num before updating currMax
            currMax = Math.max(Math.max(num, currMin * num), currMax * num);
            currMin = Math.min(Math.min(num, currMin * num), temp); // Use temp to get previous currMax * num
            maxProd = Math.max(maxProd, currMax);
        }
        return maxProd;
    }

    /**
     * Time: O(n ^ 2)
     * Space: O(1)
     * Submission Result : Not Accepted, Time Limit Exceeded
     */
    public static int bruteForce(int[] nums) {
        int maxSum = nums[0], currentSum = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                currentSum *= nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
            currentSum = 1;
        }
        return maxSum;
    }

    /**
     * Incorrect approach that fails on certain test cases
     * Reason: It does not account for negative numbers properly
     * Time: O(n)
     * Space: O(1)
     * Submission Result : Not Accepted
     */
    public static int nonWorkableSolution(int[] nums) {
        int maxProd = nums[0], currentProd = 1;
        for (int num : nums) {
            if (currentProd == 0) {
                currentProd = 1;
            }
            currentProd *= num;
            if (currentProd > maxProd) {
                maxProd = currentProd;
            }
        }
        return maxProd;
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
        test("Example 1", new int[]{2,3,-2,4}, 6);
        test("Example 2", new int[]{3,-1,4}, 4);
        test("Example 3", new int[]{-2,0,-1}, 0);
        test("Example 4", new int[]{0,2}, 2);
        test("Example 5", new int[]{-1}, -1);
        test("Example 6", new int[]{-3,-1,-1}, 3);
        test("Example 7", new int[]{-4,-3,-2}, 12);
    }
}
