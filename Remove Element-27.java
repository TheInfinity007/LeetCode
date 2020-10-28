// Problem link
// https://leetcode.com/problems/remove-element/

/*

Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length, c = 0;
        int i, j = 0;
        
        for(i = 0; i < len; i++){
            if(nums[i] != val){
                if(i != j)
                    nums[j] = nums[i];
                j++;
            }else{
                c++;
            }
        }
        //System.out.println(count +" "+ (len-count));
        return (len-c);
    }
}