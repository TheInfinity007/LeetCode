// Problem link
// https://leetcode.com/problems/subsets/

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        int len = nums.length;
        int power_set_size = (int)Math.pow(2, len);

        for(int counter = 0; counter < power_set_size; counter++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < len; i++){
                if((counter & (1 << i)) > 0){
                    temp.add(nums[i]);
                }
            }
            set.add(temp);
        }
        return new ArrayList(set);
    }
}