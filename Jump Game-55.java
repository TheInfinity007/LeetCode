// Problem link
// https://leetcode.com/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        int curr = 0, max = 0, len = nums.length;

        for(int i = 0; i < len; i++){
            if(i > curr){
                curr = max;
            }
            max = Math.max(max, i + nums[i]);
            if(max <= i)
                break;
        }
        if(curr < len-1)
            return false;
        return true;
    }
}

