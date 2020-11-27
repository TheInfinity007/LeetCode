public class test {
    public static void main(String[] args) {
        
        // int arr[] = {1, 2, 3};
        // int arr[] = {1, 3, 2};
        // int arr[] = {2, 1, 3};
        // int arr[] = {2, 3, 1};
        // int arr[] = {3, 1, 2};
        int arr[] = {3, 2, 1};
        int a, b, c, max = -99;
        a = arr[0];
        b = arr[1];
        c = arr[2];
        max = a > b ? a > c? a: c: b > c? b : c;
        max = a < b ? a < c? a: c: b < c? b : c;
        System.out.println(max);

        Integer x = 15;
        Integer y = 20;
        System.out.println("X greater" + x.compareTo(y));
        x += 5;
        System.out.println(x);

    }
}
