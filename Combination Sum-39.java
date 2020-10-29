// Problem link
// https://leetcode.com/problems/combination-sum/

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();

        backtrack(candidates, 0, target, new ArrayList(), result);
    
        return result;
    }   

    public void backtrack(int[] candidates, int start, int target, List<Integer> arr,                  List<List<Integer>> result){
        if(target < 0)
            return;
        if(target == 0)
            result.add(new ArrayList(arr));

        for(int i = start; i < candidates.length; i++){
            arr.add(candidates[i]);
            backtrack(candidates, i, target-candidates[i], arr, result);
            arr.remove(arr.size()-1);
        }
    }
}