import java.util.*; 
public class Main {
    public static void main(String[] args) {
        String s = "aabbccdef";
        char arr[] = s.toCharArray();
        int len = new Solution().compress(arr);
        for(int i = 0; i < len; i++)
            System.out.print(arr[i]);
    }
}

class Solution {
    public int compress(char[] chars) {
      	int len = chars.length;
      	if(len < 1) return 0;
      	String res = String.valueOf(chars[0]);
      	int count = 1;
      	for(int i = 1; i < len; i++){
          if(chars[i] == chars[i-1]){
            count++;
          }
          else{
            if(count > 1){
              res += count;
            }
            res += String.valueOf(chars[i]);
            count = 1;
          }
        }
      	if(count > 1) res += count;
        
        for(int i = 0; i < res.length(); i++){
            chars[i] = res.charAt(i);
        }
      	return res.length();
    }
}