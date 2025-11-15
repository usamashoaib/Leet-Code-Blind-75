package arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    /**
     * Problem: https://leetcode.com/problems/product-of-array-except-self/
     * Category: Arrays
     * Approach: Handle zero cases
     * Time: O(n)
     * Space: O(1)
     */
    public static int[] solution(int[] nums) {
        int product = 1, zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else
                zeroCount++;
        }

        if (zeroCount > 1 || zeroCount == nums.length)
            product = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = product;
            } else if (zeroCount > 0) {
                nums[i] = 0;
            } else {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

    // ---------------------------
    // Self-contained test section
    // ---------------------------
    static void test(String testName, int[] input, int[] expected) {
        int[] result = solution(input);
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

        test("Example 1", new int[]{1,2,3,4}, new int[]{24,12,8,6});
        test("With zero", new int[]{1,0,3,4}, new int[]{0,12,0,0});
        test("All zeros", new int[]{0,0}, new int[]{0,0});
    }
}
