//  Problem link
// https://leetcode.com/problems/search-in-rotated-sorted-array/

/*
You are given an integer array nums sorted in ascending order, and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.*/


class Solution {
    public int search(int[] nums, int target) {
        int pivot = 0, i, j, len = nums.length, mid;
        for(i = 1; i < len; i++){
            if(nums[i] < nums[i-1]){
                pivot = i;
                break;
            }
        }
        
        //System.out.print(pivot + " -> ");
        
        // 0 -> pivot-1
        //  pivot -> (len-1)
        
        // search in left of pivot
        i = 0; j = pivot-1;
        while(i <= j){
            mid = (i+j)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        
        
        //System.out.print(i +" "+ j + " -> ");
        
        // search in right of pivot
        i = pivot;
        j = len-1;
        while(i <= j){
            mid = (i+j)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        
         //System.out.print(i +" "+ j);
        
        return -1;
    }
}