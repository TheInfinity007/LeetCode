// Problem link
// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);

        int k = 0, len = nums.length;
        for(int i = k; i < len; i++){
            if(nums[i] == 0){
                if(i != k)
                    swap(nums, k, i);
                k++;
            }
        }
        for(int i = k; i < len; i++){
            if(nums[i] == 1){
                if(i != k)
                    swap(nums, k, i);
                k++;
            }
        }
    }

    private void swap(int[] nums, int k, int i) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
}