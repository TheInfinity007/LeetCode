// Problem link
// https://leetcode.com/problems/trapping-rain-water/

/*abstractGiven n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/

import java.util.*;

class Solution {
    public int trap(int[] height) {
        int i = 0, j, stillMax = 0, n2, len = height.length, val, x = 0, area = 0, water = 0, total;
        for(i = 0; i < len-1;){
            j = i+1;
            while(j < len && height[j] < height[i]){
                j++;
            }

            if(j < len && height[j] >= height[i]){
                area = getArea(height, i+1, j, height[i]);
                total = ((j-i-1) * height[i]);
                if(total-area > 0) water += total-area;
                i = j;
            }else{
                i++;
            }
            
        }
        return water;
    }

    public int getArea(int [] height, int start, int end, int min){
        int area = 0;
        for(int i = start; i < end; i++)
            area += Math.min(height[i], min);
        return area;
    }
}