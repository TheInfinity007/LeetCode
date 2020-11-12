// Problem link
// https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1, total = n*n;
        int res[][] = new int[n][n];

        int tr, br, lc, rc;
        tr = 0;
        lc = 0;
        rc = n-1;
        br = n-1;
        while(lc <= rc && tr <= br){
            for(int i = lc; i <= rc; i++){
                res[tr][i] = count++;
            }
            tr++;

            for(int i = tr; i <= br; i++){
                res[i][rc] = count++;
            }
            rc--;

            for(int i = rc; i >= lc; i--){
                res[br][i] = count++;
            }
            br--;

            for(int i = br; i >= tr; i--){
                res[i][lc] = count++;
            }
            lc++;
        }
        return res;
    }
}