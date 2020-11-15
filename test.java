public class test {
    public static void main(String[] args) {
        char []set = {'a', 'b', 'c'}; 
        for(int counter = 0; counter < 3; counter++){
            for(int j = 0; j < 3; j++){
                System.out.print(counter + " " + j + " " + (1 << j) + " " + (counter&(1<<j)));
                    if((counter&(1<<j)) > 0)
                        System.out.println(" " + set[j]);
                    else   
                        System.out.println();
            }
            System.out.println();
        }

    }
}
