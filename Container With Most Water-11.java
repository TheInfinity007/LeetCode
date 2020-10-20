// Problem link
// https://leetcode.com/problems/container-with-most-water/

import java.util.Stack;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        // int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        // int hist[] = {2,4,3,5,6,5,4,2,3,1};
        int hist [] = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum area is " + new Solution().maxArea(hist));
    }
}

class Solution {
    public int maxArea(int[] height) {
        Stack <Integer> stk = new Stack<Integer>();
        int i, j, area = 0, maxArea = 0, n1, n2;
        i = 0;
        j = height.length-1;
        while(i < j){
            n1 = height[i];
            n2 = height[j];
            area = (j-i)* ((n2-n1) > 0? n1: n2);

            if(n1 <= n2){
                i++;
            }else{
                j--;
            }
            System.out.println(area);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
