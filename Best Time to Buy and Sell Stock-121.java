// Problem Link
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        
        int cp = prices[0], profit, maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            profit = prices[i]-cp;
            if(profit < 0) cp = prices[i];
            else if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        if(maxProfit <= 0)
            return 0;
        return maxProfit;
    }
}