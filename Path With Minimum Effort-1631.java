// Problem link
// https://leetcode.com/problems/path-with-minimum-effort/submissions/

// This is dfs traversal solution

class Solution {
    public static void main(String args[]){
        int heights[][] = {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };

        int heights2[][] = {{1,10,6,7,9,10,4,9}};
        System.out.println("REsult = " + new Solution().minimumEffortPath(heights2));
    }

    static int minGap = Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {
        int R = heights.length;
        if(R < 1) return 0;
        int C = heights[0].length;
        int visited[][] = new int[R][C];
        
        int gap = 0;
        traverse(heights, visited, 0, 0, R-1, C-1, gap, heights[0][0]);
        return minGap;
    }

    private boolean traverse(int[][] heights, int[][] visited, int i, int j, int r, int c, int gap, int prev) {
        
        if(i < 0 || j < 0 || i > r || j > c) return false;
        
        if(visited[i][j] == 1) return false;

        int diff = Math.abs(prev-heights[i][j]);
        gap = Math.max(diff, gap);
        if(gap >= minGap) return false;
        
        visited[i][j] = 1;        

        if(i == r && j == c){
            if(gap < minGap) minGap = gap;
            visited[i][j] = 0;
            return true;
        }

        prev = heights[i][j];

        traverse(heights, visited, i, j+1, r, c, gap, prev);   // right
        traverse(heights, visited, i+1, j, r, c, gap, prev);   // down
        traverse(heights, visited, i, j-1, r, c, gap, prev);   // left
        traverse(heights, visited, i-1, j, r, c, gap, prev);   // up
        visited[i][j] = 0;

        return false;
    }
}