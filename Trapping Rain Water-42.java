// Problem link
// https://leetcode.com/problems/trapping-rain-water/

/*abstractGiven n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/

import java.util.*;

class Solution {
    public int trap(int[] height) {
        int water = 0, len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];
        int maxLeft = 0;
        int maxRight = 0;
        for(int i = 0; i < len; i++){
            maxLeft = Math.max(maxLeft, height[i]);
            left[i] = maxLeft;
        }
            
        for(int i = len-1; i >= 0; i--){
            maxRight = Math.max(maxRight, height[i]);
            right[i] = maxRight;
        }
            
        
        for(int i = 1; i < len-1; i++){
            maxLeft = left[i-1];
            maxRight = right[i+1];
            int diff = Math.min(maxLeft, maxRight)-height[i];
            water += diff >= 0 ? diff : 0;
        }
        return water;
    }

    public int calculateArea(){
        int area = 0;


        return area;
    }

    public int getArea(int [] height, int start, int end, int min){
        int area = 0;
        for(int i = start; i < end; i++)
            area += Math.min(height[i], min);
        return area;
    }
}