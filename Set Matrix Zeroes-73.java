// Problem link
// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = 0;
        if(row > 0)
            col = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}