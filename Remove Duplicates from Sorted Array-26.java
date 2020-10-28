// Problem link
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

/*

Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0, len = nums.length;
        int i, j = 0;
        for(i = 1; i < len; i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }else{
                count++;
            }
        }
        //System.out.println(count + " " + (len-count));
        
        return (len-count);
    }
}