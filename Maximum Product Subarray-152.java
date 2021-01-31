// Problem link
// https://leetcode.com/problems/maximum-product-subarray/


class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length < 1) return 0;
        
        int product = nums[0], max = nums[0];
        int i, j;

        // traverse array left to right
        for(i = 1; i < nums.length; i++){
            product = (product == 0)? nums[i]: product*nums[i];
            if(product > max) max = product;
            if(nums[i] > max) max = nums[i];
        }
        


        // traverse array from right to left;
        // In case of odd no of -ve no's we have to either skip first -ve no or last -ve no

        product = nums[nums.length-1];
        if(product > max) max = product;
        for(i = nums.length-2; i >= 0; i--){
            product = (product == 0)? nums[i]: product*nums[i];
            if(product > max) max = product;
            if(nums[i] > max) max = nums[i];
        }
       
        return max;
    }
}