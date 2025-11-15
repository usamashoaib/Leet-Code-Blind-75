package arrays;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Problem: https://leetcode.com/problems/contains-duplicate/
     * Category: Arrays
     * Approach: Using HashSet to track seen elements
     * Time: O(n)
     * Space: O(n)
     * LeetCode Result : Accepted, Runtime time: 35 ms, Beats : 5% , Memory usage: 102.33 MB, Beats : 5%
     */
    public static boolean solution(int[] nums) {
        Set<String> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(String.valueOf(num))) {
                return true;
            }
            seen.add(String.valueOf(num));
        }
        return false;
    }

    // ---------------------------
    // Self-contained test section
    // ---------------------------
    static void test(String testName, int[] input, boolean expected) {
        boolean result = solution(input);
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

        test("Example 1", new int[]{1,2,3,1}, true);
        test("Example 2", new int[]{1,2,3,4}, false);
        test("Example 3", new int[]{1,1,1,3,3,4,3,2,4,2}, true);
    }
}
