// Problem link
// https://leetcode.com/problems/search-a-2d-matrix/



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = 0;
        if(rows > 0)
            cols = matrix[0].length;
        
        for(int i = 0; i < rows; i++){
            if(matrix[i][cols-1] >= target){
                for(int j = 0; j < cols; j++){
                    if(matrix[i][j] == target)
                        return true;
                }
                return false;
            }
        }
        return false;
    }
}