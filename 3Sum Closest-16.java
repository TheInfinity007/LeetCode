// problem link
// https://leetcode.com/problems/3sum-closest/

import java.util.*;
public class SumClosest_16 {
    public static void main(String[] args) {
        int nums[] = {-1,2,1,-4};
        int target = 1;
        int res = new Solution().threeSumClosest(nums, target);
        System.out.println(res);
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum, diff, i, j, len, start, end, res = target, minDiff = 99999;
        Arrays.sort(nums);

        len = nums.length;

        for(i = 0; i < len-1; i++){
            start = i+1;
            end = len-1;
            while(start < end){
                sum = nums[i] + nums[start] + nums[end];
                diff = target - sum;
                if(Math.abs(diff) < minDiff){
                    minDiff = Math.abs(diff);
                    res = sum;
                }
                if(diff < 0){
                    end--;
                }else if(diff > 0){
                    start++;
                }else{
                    return res;
                }
            }
        }
        return res;
    }
}