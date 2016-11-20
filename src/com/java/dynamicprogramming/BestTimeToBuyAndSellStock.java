package com.java.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int leastStockPrice = Integer.MAX_VALUE;
        int totalMaxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            leastStockPrice = Math.min(leastStockPrice, prices[i]);
            totalMaxProfit = Math.max(totalMaxProfit, prices[i] - leastStockPrice);
        }
        return totalMaxProfit;
    }
}
