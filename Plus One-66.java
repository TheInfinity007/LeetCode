// Problem link
// https://leetcode.com/problems/plus-one/

import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flag = false;

        for(int i = len-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                flag = true;
                break;
            }else{
                digits[i] = 0;
            }
        }

        if(flag)
            return digits;
        
        int[] res = new int[len+1];
        res[0] = 1;
        for(int i = 0; i < len; i++){
            res[i+1] = digits[i];
        }
        return res;
    }
}