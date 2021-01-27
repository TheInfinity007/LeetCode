// Problem link
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        ArrayList<Integer> profits = new ArrayList<Integer>();

        int max1 = 0, max2 = 0, profit = 0

        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] <= prices[i+1]){
                profit += prices[i+1]-prices[i];
            }else{
                if(profit >= max1){
                    max2 = max1;
                    max1 = profit;
                }else if(profit >= max2){
                    max2 = profit;
                }
                profit = 0;
            }
        }
        if(profit >= max1){
            max2 = max1;
            max1 = profit;
        }else if(profit >= max2){
            max2 = profit;
        }
        return max1+max2;
    }
}