public class Solution {
    // you need to treat n as an unsigned value
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(3));
    }

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0) count++;
            mask = mask << 1;
        }
        return count;
    }


    // This will not work for -ve value of n
    // public int hammingWeight(int n) {
    // 	int count = 0;
    //     while(n != 0){
    //     	if((n&1) != 0) count++;
    //     	n >>= 1;
    //     }
    //     return count;
    // }
}