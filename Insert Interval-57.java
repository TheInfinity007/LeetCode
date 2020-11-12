// Problem link
// https://leetcode.com/problems/insert-interval/

import java.util.*;

class Main{
    public static void main(String[] args) {
        // int res[][] = {{1,2}, {3,5},{6,7},{8,10},{12,16}};      //{4,8}
        // int res[][] = {{1,3},{6,9}};         // {2,5}
        int res[][] = {};         // {5,7}
        // int res[][] = {{1,5}};         // {2,7}
        // int res[][] = {{1,5}};         // {6,8},
        // int res[][] = {{1,5}};         // {0,3},
        int ans[][] = new Solution().insert(res, new int[]{5,7});
        print(ans);

        
    }

    public static void print(int[][] arr){
        System.out.println("Printing array");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<int[]>();

        // storing all the non overlaping
        int i = 0, len = intervals.length;
        while(i < len){
            if(intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
            }else
                break;
            i++;
        }

        // new Main().print(res.toArray(new int[res.size()][2]));
        // gathering all the overlaping 
        while(i < len){
            if(newInterval[1] >= intervals[i][0]){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            else
                break;
            i++;
        }

        res.add(newInterval);
        // new Main().print(res.toArray(new int[res.size()][2]));

        // gathering all the remaining non-overlaping 
        while(i < len){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}