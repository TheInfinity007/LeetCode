// Problem link
// https://leetcode.com/problems/pascals-triangle/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        ArrayList<Integer>temp = new ArrayList<Integer>();
        
        if(numRows < 1)
            return list;

        temp.add(1);
        list.add(temp); 

        for(int i = 1; i < numRows; i++){
            temp = new ArrayList<Integer>();
            for(int j = 0; j < i; j++){
                if(j == 0)
                    temp.add(list.get(list.size()-1).get(0));
                else if(j == i){
                    temp.add(list.get(list.size()-1).get(i-1));
                }else{
                    temp.add(list.get(list.size()-1).get(j-1) + list.get(list.size()-1).get(j));
                }
            }
            list.add(temp);
        }

        return list;
    }
}