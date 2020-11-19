// Problem link
// https://leetcode.com/problems/maximal-rectangle/

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int i, j, h, w = 0, max = 0, area;
        h = matrix.length;
        if(h < 1) return 0;
        w = matrix[0].length;

        int[] heights = new int[w];

        for(i = 0; i < w; i++){
            heights[i] = matrix[0][i]-'0';
        }
        
        area = LargestRectangleArea(heights);
        if(area > max) max = area;
        
        System.out.println(0 + " " + area);

        for(i = 1; i < h; i++){
            for(j = 0; j < w; j++){
                if(matrix[i][j]-'0' == 1){
                    heights[j] = matrix[i][j]-'0' + matrix[i-1][j]-'0';
                    matrix[i][j] = (char)(heights[j] + '0');
                }
                    
                else
                    heights[j] = 0;
            }
            area = LargestRectangleArea(heights);
            System.out.println(i + " " + area);
            if(area > max) max = area;                
        }
        return max;
    }
    private int LargestRectangleArea(int[] heights) {
        int area, max = 0, i, index, val;
        Stack<Integer> stk = new Stack<Integer>();

        for(i = 0; i < heights.length; i++){
            if(stk.size() == 0 || heights[stk.peek()] <= heights[i]){
                stk.push(i);
            }else{
                while(stk.size() != 0 && heights[stk.peek()] > heights[i]){
                    index = stk.pop();
                    val = heights[index];
                    area = val * (stk.size() == 0 ? i:(i-stk.peek()-1));
                    if(area > max) max = area;
                }
                stk.push(i);
            }
        }

        while(stk.size() != 0){
            index = stk.pop();
            val = heights[index];
            area = val * (stk.size() == 0 ? i:(i-stk.peek()-1));
            if(area > max) max = area;
        }
        return max;
    }
}