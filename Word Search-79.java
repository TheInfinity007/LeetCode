// Problem link
// https://leetcode.com/problems/word-search/

import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        int h = board.length, w = 0;
        if(h < 1)
            return false;
        w = board[0].length;

        Set<ArrayList<Integer>> steps = new HashSet<ArrayList<Integer>>();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j] == word.charAt(0)){
                    found = search(board, i, j, h-1, w-1, word.toCharArray(), 0, steps);
                    if(found == true)
                        return found;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, int h, int w, char[] word, int k,
            Set<ArrayList<Integer>> steps) {
        if (k == (word.length))
            return true;

        if (i > h || j > w || i < 0 || j < 0)
            return false;

        if(board[i][j] == word[k]){
            steps.add(new ArrayList<Integer>(Arrays.asList(i, j)));

            if(!steps.contains(Arrays.asList(i, j+1)) && search(board, i, j+1, h, w, word, k+1, steps))
                return true;

            if(!steps.contains(Arrays.asList(i+1, j)) && search(board, i+1, j, h, w, word, k+1, steps))
                return true;
                
            if(!steps.contains(Arrays.asList(i, j-1)) && search(board, i, j-1, h, w, word, k+1, steps))
                return true;

            if(!steps.contains(Arrays.asList(i-1, j)) && search(board, i-1, j, h, w, word, k+1, steps))
                return true;

            steps.remove(Arrays.asList(i, j));
        }
        return false;
    }
}