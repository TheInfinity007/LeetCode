// Problem  link
// https://leetcode.com/problems/spiral-matrix/

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        int h = matrix.length;
        if(h < 1) return new ArrayList();

        int w = matrix[0].length;

        int tr, lc, rc, br; // top-row left-column right-column bottom-row
        tr = 0;
        lc = 0;
        rc = w-1;
        br = h-1;
        
        while(tr <= br && lc <= rc){
            for(int i = lc; i <= rc; i++){
                res.add(matrix[tr][i]);
            }
            tr++;
            
            if(tr > br || lc > rc) break;
            
            for(int i = tr; i <= br; i++){
                res.add(matrix[i][rc]);
            }
            rc--;
            if(tr > br || lc > rc) break;
            
            for(int i = rc; i >= lc; i--){
                res.add(matrix[br][i]);
            }
            br--;
            if(tr > br || lc > rc) break;
            
            for(int i = br; i >= tr; i--){
                res.add(matrix[i][lc]);
            }
            lc++;
        }
        return res;
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int h = matrix.length;
        int w = matrix[0].length;
        int d = w%2 == 1? w/2+1: w/2;

        for(int i = 0; i < d; i++){
            // top row
            for (int j = i; j <= w-i-1; j++) {
                System.out.print(matrix[i][j] + " ");
                res.add(matrix[i][j]);
            }
            // right column
            for(int j = i+1; j <= h-i-1; j++){
                System.out.print(matrix[j][w-i-1] + " ");
                res.add(matrix[j][w-i-1]);
            }

            // Bottom row
            for(int j = w-i-2; j >= i && h-1-i > i; j--){
                System.out.print(matrix[h-1-i][j] + " ");
                res.add(matrix[h-1-i][j]);
            }

            // left column
            for(int j = h-i-2; j >= i+1; j--){
                System.out.print(matrix[j][i] + " ");
                res.add(matrix[j][i]);
            }
        }
        return res;
    }
}