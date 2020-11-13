// Problem link
// https://leetcode.com/problems/unique-paths-ii/

import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int count = 0, m, n;
        m = obstacleGrid.length;
        if(m < 1)
            return 0;
        n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);

        count = getUniquePaths(obstacleGrid, 0, 0, m-1, n-1, dp);
        return count;
    }

    private int getUniquePaths(int[][] obstacleGrid, int i, int j, int k, int l, int [][]dp) {
        if(i >= k && j >= l)
            if(obstacleGrid[i][j] == 0)
                return 1;
            else
                return 0;
        int count = 0;
        if(obstacleGrid[i][j] == 1)
            return count;

        if(j < l){
            if(dp[i][j+1] != -1)
                count += dp[i][j+1];
            else{
                dp[i][j+1] = getUniquePaths(obstacleGrid, i, j+1, k, l, dp);
                count += dp[i][j+1];
            }
        }
                
        if(i < k)
            if(dp[i+1][j] != -1)
                count += dp[i+1][j];
            else{
                dp[i+1][j] = getUniquePaths(obstacleGrid, i+1, j, k, l, dp);
                count += dp[i+1][j];
            }
        return count;
    }
}