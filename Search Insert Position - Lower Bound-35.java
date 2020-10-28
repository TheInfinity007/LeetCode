// Problem link
// https://leetcode.com/problems/search-insert-position/submissions/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l, r, mid, len = nums.length;
        
        l = 0;
        r = len-1;
        while(l <= r){
            mid = l+ (r-l)/2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] > target)
                r = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}