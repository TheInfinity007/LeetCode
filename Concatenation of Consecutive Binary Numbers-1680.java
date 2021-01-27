// Problem link
// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

/*
Input: n = 3
Output: 27
Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
After concatenating them, we have "11011", which corresponds to the decimal value 27.


Constraints:
1 <= n <= 10^5
*/

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int res = new Solution().concatenatedBinary(418);
        System.out.println(res);
    }   
    
    HashMap<Integer, String>map = new HashMap<Integer, String>();
    public int concatenatedBinary(int n) {
        map = new HashMap<Integer, String>();
        String str = "";
        for(int i = 1; i <= n; i++){
            str += decimalToBinary(i);
        }

        int j = 0, res = 0, max = 1000000007;       // max = 10^9+7
    

        // For large values its not possible to calculate the power to the base 2

        // for(int i = str.length()-1; i >= 0; i--, j++){
        //     res = (int)(res + (str.charAt(i)-'0')*(Math.pow(2, j)%max))%max;
        // }

        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) == '1' ? 1: 0;
            res = ((res*2)%max + val)%max;
        }

        return res;
    }

    // more efficient than above
    // in the above function we are concatenating all the binaries. The length of the string can be too big for big values.
    // It will take a large space to store and also a large time to traverse all the characters of the string.
    public int concatenatedBinary(int n) {
        map = new HashMap<Integer, String>();
        String str = "";
        int j = 0, res = 0, max = 1000000007;       // max = 10^9+7
        for(int i = 1; i <= n; i++){
            // str += decimalToBinary(i);           // we can also use our function to get the binary string
            str = Integer.toBinaryString(i);        // built-in method
            for(char ch: str.toCharArray()){
                int val = (ch == '1') ? 1: 0;
                res = ((res*2)%max + val)%max;
            }
        }
        return res;
    }


    private String decimalToBinary(int i) {
        // used memorisation technique
        if(map.containsKey(i)) return map.get(i);
        if( i < 1) return "";
        String s = decimalToBinary(i/2);
        s += String.valueOf(i%2);
        map.put(i, s);
        return s;
    }

}