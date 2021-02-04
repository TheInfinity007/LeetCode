// Problem link
// https://leetcode.com/problems/reverse-words-in-a-string/

class Solution {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String arr[] = s.trim().split(" +");
        for(int i = arr.length-1; i >= 0; i--){
            sb.append(arr[i]);
            if(i > 0) sb.append(" ");
        }
        return sb.toString();
    }
}