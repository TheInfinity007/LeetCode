// PRoblem link
// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int val, index, max = 0, area, i;
        for(i = 0; i < heights.length; i++){
            val = heights[i];
            if(stk.size() == 0 || heights[i] >= heights[stk.peek()]){
                stk.push(i);
            }else{
                // calculate area
                while(stk.size() != 0 && heights[stk.peek()] > heights[i]){
                    index = stk.pop();
                    val = heights[index];
                    area = val * (stk.size() == 0 ? i: (i-stk.peek()-1));
                    if(area > max) max = area;
                }
                stk.push(i);
            }
        }

        while(stk.size() != 0){
            index = stk.pop();
            val = heights[index];
            area = val * (stk.size() == 0 ? i: (i-stk.peek()-1));
            if(area > max) max = area;            
        }
        return max;
    }
}