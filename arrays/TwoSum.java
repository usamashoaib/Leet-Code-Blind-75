package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /**
     * Problem: https://leetcode.com/problems/two-sum/
     * Difficulty: Easy
     * Category: Arrays
     * Approach: Using Hash Set
     * Time: O(n)
     * Space: O(n)
     */
    public static int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            numToIndex.put(nums[i], i);
        }
        return nums;
    }

    // ---------------------------
    // Self-contained test section
    // ---------------------------
    static void test(String testName, int[] input, int target, int[] expected) {
        int[] result = solution(input, target);
        if (!Arrays.equals(result, expected)) {
            System.out.println("❌ " + testName
                    + " | expected=" + Arrays.toString(expected)
                    + " but got=" + Arrays.toString(result));
        } else {
            System.out.println("✅ " + testName);
        }
    }

    public static void main(String[] args) {
        System.out.println("Running tests...\n");
        test("Test 1", new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        test("Test 2", new int[]{3, 2, 4}, 6, new int[]{1, 2});
        test("Test 3", new int[]{3, 3}, 6, new int[]{0, 1});
    }
}
