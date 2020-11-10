// Problem link]
// https://leetcode.com/problems/merge-intervals/

import java.util.*;

class Main{
    public static void main(String[] args) {
        // int res[][] = {{2,6}, {1,3},{8,10},{15,18}};
        int res[][] = {{1,4},{0,0}};
        int ans[][] = new Solution().merge(res);
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
    public int[][] merge(int[][] intervals) {
        int [][] res;

        if(intervals.length == 0){
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        new Main().print(intervals);

        int i, n = intervals.length;
        ArrayList<ArrayList<Integer>>arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(i = 0; i < n; i++){
            if(temp.size() == 2){
                if(temp.get(1) >= intervals[i][0]){
                    if(temp.get(0) > intervals[i][0])
                        temp.set(0, intervals[i][0]);
                    if(temp.get(1) < intervals[i][1])
                        temp.set(1, intervals[i][1]);
                }else{
                    arr.add(temp);
                    temp = new ArrayList<Integer>();
                    temp.add(intervals[i][0]);
                    temp.add(intervals[i][1]);
                }
            }else{
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
            }                
        }
        arr.add(temp);
        res = new int[arr.size()][2];
        for(i = 0; i < arr.size(); i++){
            res[i][0] = arr.get(i).get(0);
            res[i][1] = arr.get(i).get(1);
        }
        return res;
    }
}