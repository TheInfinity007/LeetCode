// Problem link
// https://leetcode.com/problems/subsets-ii/

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int len = nums.length;
        int power_set_size = (int)Math.pow(2, len);

        Arrays.sort(nums);

        for(int i = 0; i < power_set_size; i++){
            for(int j = 0; j < len; j++){
                if((i & 1 << j) > 0){
                    temp.add(nums[j]);
                }
            }
            set.add(temp);
            temp = new ArrayList<Integer>();
        }
        return new ArrayList(set);
    }
}