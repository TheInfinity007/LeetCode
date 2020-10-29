// Problem link
// https://leetcode.com/problems/combination-sum-ii/

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
*/

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, new ArrayList(), result);

        // result will contain duplicates
        Set<Set<Integer>> set = new HashSet(result);
        result = new ArrayList(set);
        return result;
    }

    public void backtrack(int[] candidates, int start, int target, List<Integer> arr, List<List<Integer>> result){
        if(target < 0)
            return;
        if(target == 0)
            result.add(new ArrayList(arr));

        for(int i = start; i < candidates.length; i++){
            arr.add(candidates[i]);
            backtrack(candidates, i+1, target-candidates[i], arr, result);
            arr.remove(arr.size()-1);
        }
    }
}