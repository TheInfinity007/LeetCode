// Problem link
// https://leetcode.com/problems/4sum/

import java.util.*;
public class Sum_18 {
    public static void main(String[] args) {
        int nums[] = {1,0,-1,0,-2,2};
        // Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int target = 0;
        List<List<Integer>> list = new Solution().fourSum(nums, target);
        for(List<Integer> li: list){
            for(Integer x: li){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res;
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        int len = nums.length, sum, l, r;
        for(int i = 0; i < len-3; i++){
            for(int j = i+1; j < len-2; j++){
                l = j+1;
                r = len-1;
                while(l < r){
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }

        res = new ArrayList<>(set);
        return res;
    }
}