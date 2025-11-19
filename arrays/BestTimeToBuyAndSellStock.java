package arrays;

import java.util.Objects;

public class BestTimeToBuyAndSellStock {
    /**
     * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * Category: Arrays
     * Approach: Using two pointers to track the minimum buying price and calculate maximum profit
     * Time: O(n)
     * Space: O(1)
     */
    public static int solution(int[] prices) {
        int maxProfit = 0, left = 0, right = 0;
        while (right < prices.length) {
            int priceDiff = prices[right] - prices[left];
            if (priceDiff > maxProfit) {
                maxProfit = priceDiff;
            }
            if (prices[left] > prices[right]) {
                left = right;
            }
            right++;
        }
        return maxProfit;
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
        test("Example 1", new int[]{7, 1, 5, 3, 6, 4}, 5);
        test("Example 2", new int[]{7, 6, 4, 3, 1}, 0);
        test("Example 3", new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 7);
    }
}
