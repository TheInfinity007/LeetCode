// Problem link
// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return 0;
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1]-nums[i] == 1){
                count++;
            }else if(nums[i+1] != nums[i]){
                if(count > max) max = count;
                count = 1;
            }
        }
        if(count > max) max = count;
        return max;
    }
}

class Solutions {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return 0;
        
        int max = 0;
        int count = 1;
        int currValue;
        Set<Integer>set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(Integer item: set){
            if(!set.contains(item-1)){
                count = 1;
                currValue = item;
                while(set.contains(currValue+1)){
                    currValue++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}