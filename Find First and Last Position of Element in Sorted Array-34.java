// Problem link
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm with O(log n) runtime complexity?
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l, r, mid, len = nums.length, index1 = -1, index2 = -1;
        
        l = 0;
        r = len-1;
        
        // for lower bound
        
        while(l <= r){
            mid = l + (r-l)/2;
            if(nums[mid] == target){
                index1 = mid;
            }
                            
            if(nums[mid] >= target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        
        // for upper bound
        l = 0;
        r = len-1;
        while(l <= r){
            mid = l+ (r-l)/2;
            if(nums[mid] == target)
                index2 = mid;
            
            if(nums[mid] <= target)
                l = mid+1;
            else
                r = mid-1;
        }
        
        //System.out.println(index1 +" "+ index2);
        
        int res[] = { index1, index2};
        return res;
    }
}