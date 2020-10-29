// Problem link
// https://leetcode.com/problems/first-missing-positive/

/*abstractGiven an unsorted integer array nums, find the smallest missing positive integer.
Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
*/


// The idea is to do counting sort in-place in the nums array.
import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // Arrays.sort(nums);
        int elemPos, n = nums.length;
        for(int i = 0; i < n; i++){
            elemPos = nums[i]-1;
            
            // element is in its correct position
            if(elemPos == i)
                continue;
            else{
                // Placing all the elements of ith index to their correct positions
                while(elemPos >= 0 && elemPos < n){
                    swap(nums, i, elemPos);
                    if(nums[i]-1 == elemPos) break;
                    elemPos = nums[i]-1;
                }
            }
        }
        
        
        
        
        int missing = 1;
        
        for(int i = 0; i < nums.length; i++){
            System.out.print(i + " ");
            if(nums[i] == missing)
                missing++;
            else if(nums[i] > missing)
                break;
            
        }
        return missing;
    }
    
    public void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}