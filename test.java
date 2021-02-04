import java.util.*; 
public class test {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
        

    }

    public static String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");

        String temp;
        for(int i = 0; i < arr.length/2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }

        s = String.join(" ", arr);
        return s;     
    }
}