// Problem link
// https://leetcode.com/problems/pascals-triangle-ii/

import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>lastRow = new ArrayList<Integer>();
        List<Integer>currRow = new ArrayList<Integer>();
        if(rowIndex < 0) return currRow;

        lastRow.add(1);

        for(int i = 1; i <= rowIndex; i++){
            currRow = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    currRow.add(1);
                else
                    currRow.add(lastRow.get(j) + lastRow.get(j-1));
            }
            lastRow = currRow;
        }

        return lastRow;
    }
}