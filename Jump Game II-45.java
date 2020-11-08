// Problem link
// https://leetcode.com/problems/jump-game-ii/

import java.util.Arrays;


class Solution {
    public int jump(int[] nums) {
        int jump = 0, curr = 0, max = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > curr){
                curr = max;
                jump++;
            }
            max = Math.max(max, i + nums[i]);
        }
        return jump;
    }
}


// Recursive solution
/*
class Solution {
    static int[] dp;
    public int jump(int[] nums) {
        int jump = Integer.MAX_VALUE, len = nums.length;

        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length-1] = 0;
       
        jump = getJump(nums, 0, len-1);
        return jump;
    }

    private int getJump(int[] nums, int start, int end) {
        if(start >= end){
            return 0;
        }
        
        if(dp[start] != -1){
            return dp[start];
        }
            
        int jump = nums.length;
        for(int i = nums[start]; i > 0 ; i--){
            int val = getJump(nums, start+i, end) + 1;
            jump = Math.min(val, jump);
            if(jump == 1)
                break;
        }
        
        dp[start] = jump;
        return jump;
    }
}*/