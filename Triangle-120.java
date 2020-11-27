// Problem link
// https://leetcode.com/problems/triangle/

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int index = 0, max = 0, n = triangle.size();
        if(n < 1) return 0;

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}