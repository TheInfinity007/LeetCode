public class test {
    public static void main(String[] args) {
        String str = "123";
        int num = strToNum(str);
        System.out.println(num);
    }

    public static int strToNum(String str){
        char [] charArr = str.toCharArray();
        int value = 0;

        for(int i = 0; i < str.length(); i++){
            System.out.println(Integer.valueOf(charArr[i]-48) * Math.pow(10, i));
            System.out.println(Character.getNumericValue(charArr[i]) + ">");
            value = (value * 10) + (charArr[i]-'0');
            System.out.println(value);
        }


        return value;
    }

}
