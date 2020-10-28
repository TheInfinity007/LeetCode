// Problem link
// https://leetcode.com/problems/next-permutation/

/*

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

*/

import java.util.Arrays;
class Solution {
    public void nextPermutation(int[] nums) {        
        int i, j, min, len = nums.length, temp;
        
        if(len <= 1)
            return;
        for(i = len-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                break;
            }
        }
        
        if(i < 1){
            Arrays.sort(nums);
            return;
        }
        
        min = i;
        
        for(j = i+1; j < len; j++){
            if((nums[min] > nums[j]) && (nums[j] > nums[i-1])){
                min = j;
            }
        }
        
        // swap
        temp = nums[i-1];
        nums[i-1] = nums[min];
        nums[min] = temp;
        
        Arrays.sort(nums, i, len);
    }
}