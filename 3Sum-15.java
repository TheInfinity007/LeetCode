// problem link
// https://leetcode.com/problems/3sum/
//Both solutions do work;

import java.util.*;
public class Sum_15 {
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = new Solution().threeSum(nums);
        for(List<Integer> li: list){
            for(Integer x: li){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}


// Solution 1

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
       
//         Arrays.sort(nums);
//         int n1, n2, n3, sum = 0, diff, row = 0;

//         for(int i = 0; i < nums.length && nums[i] <= 0; i++){
//             if(i == 0 || nums[i] != nums[i-1]){
//                 twoSum(nums, res, i);
//             }
//         }    
        
//         return res;
//     }
//     public void twoSum(int nums[], List<List<Integer>> res, int i){
//         int j = nums.length-1;
//         int val = nums[i];
//         int sum;
//         i += 1;
//         while(i < j){
//             sum = val + nums[i] + nums[j];
//             if(sum < 0){
//                 i++;
//             }else if(sum > 0){
//                 j--;
//             }else{  // Sum is zero
//                 List <Integer> list = new ArrayList<Integer>();
//                 list.add(val);
//                 list.add(nums[i]);
//                 list.add(nums[j]);
//                 res.add(list);
//                 i++;
//             }
//         }
//     }
// }


// Solution 2

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Set<List<Integer>> set = new HashSet<>();
        
        if (nums.length < 3 || nums == null) {
            return new ArrayList<>();
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        // return new ArrayList<>(set);
        return res;
    }
       
}