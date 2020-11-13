// Problem link
// https://leetcode.com/problems/unique-paths/

//Input: m = 3, n = 7
//Output: 28

import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int count = 0;
        // target = [2,6]
        int dp[][] = new int[m][n];
        
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);

        count = getPath(0, 0, m-1, n-1, dp);

        return count;
    }

    private int getPath(int i, int j, int k, int l, int[][] dp) {
        if(i >= k && j >= l)
            return 1;
        int count = 0;
        if(j < l){
            if(dp[i][j+1] != -1)
                count += dp[i][j+1];
            else{
                dp[i][j+1] = getPath(i, j+1, k, l, dp);
                count += dp[i][j+1];
            }   
        }
        if(i <  k){
            if(dp[i+1][j] != -1)
                count += dp[i+1][j];
            else{
                dp[i+1][j] = getPath(i+1, j, k, l, dp);
                count += dp[i+1][j];
            }
        }        
        return count;
    }
}