// Problem link
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        int val, index, max = 0, total = 0, top = 0, profit;
        
        Stack<Integer>stk = new Stack<Integer>();

        for(int i = 0; i < prices.length; i++){
            if(stk.size() == 0 || prices[stk.peek()] <= prices[i])
                stk.push(i);
            else{
                top = prices[stk.peek()];
                while(stk.size() > 1g){
                    stk.pop();
                    profit = top-prices[stk.peek()];
                    if(profit > max) max = profit;
                }
                stk.pop();
                total += max;
                max = 0;
                stk.push(i);
            }
        }

        top = 0;
        if(stk.size() > 1) top = prices[stk.peek()];
        while(stk.size() > 1){
            stk.pop();
            profit = top-prices[stk.peek()];
            if(profit > max) max = profit;
        }
        total += max;

        return total;
    }
}