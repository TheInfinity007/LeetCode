// Problem link
// https://leetcode.com/problems/insert-interval/

import java.util.*;

class Main{
    public static void main(String[] args) {
        // int res[][] = {{1,2}, {3,5},{6,7},{8,10}};
        int res[][] = {{1,3},{6,9}};
        int ans[][] = new Solution().insert(res, new int[]{2,5});
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
        int res[][] = new int[0][];
        if(newInterval.length < 1) return intervals;

        ArrayList<ArrayList<Integer> arr = new ArrayList();
        ArrayList <Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]){
                if(temp.size() == 2){
                    arr.add(temp);
                    temp = new ArrayList<Integer>();
                }
                temp.add(Math.min(intervals[i][0], newInterval[0]));
                temp.add(Math.max(intervals[i][1], newInterval[1]));
            }else{
                if(temp.size() == 2){
                    arr.add(temp);
                    temp = new ArrayList<Integer>();
                }
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
            }
        }
        arr.add(temp);
        res = new int[arr.size()][2];
        for(int i = 0; i < arr.size(); i++){
            res[i][0] = arr.get(i).get(0);
            res[i][1] = arr.get(i).get(1);
        }
        return res;
    }
}