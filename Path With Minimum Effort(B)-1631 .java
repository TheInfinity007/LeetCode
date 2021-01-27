// Problem link
// https://leetcode.com/problems/path-with-minimum-effort/submissions/

// This soultion is using the dijkshtras algorithm
// This is more efficient than the previous(dfs traversal algo)

import java.util.*;

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

    int dir[] = new int[]{0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;

        int efforts[][] = new int[R][C];

        for(int[] effort: efforts){
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0]-b[0]));

        pq.add(new int[]{0,0,0});
        efforts[0][0] = 0;

        while(pq.size() != 0){
            int [] head = pq.poll();
            int x = head[1];
            int y = head[2];
            int currEffort = head[0];

            if(x == R-1 && y == C-1) return currEffort;

            for(int k = 0; k < 4; k++){
                int nx = x + dir[k];
                int ny = y + dir[k+1];

                if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                    int nextEffort = Math.max(currEffort, Math.abs(heights[x][y]-heights[nx][ny]));
                    if(nextEffort < efforts[nx][ny]){
                        efforts[nx][ny] = nextEffort;
                        pq.add(new int[]{nextEffort, nx, ny});
                    }
                }
            }
        }
        return 0;
    }

   
}