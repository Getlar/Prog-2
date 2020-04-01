import java.util.Scanner;

public class Lotot {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int min, max;
        int tmp;
        min = 90;
        max = 0;
        while(sc.hasNextLine()) {
            String[] darabolt = sc.nextLine().split(" ", 6);
            for(int i = 1; i < darabolt.length; i++){
                tmp = Integer.parseInt(darabolt[i]);
                if(tmp >= max){
                    max = tmp;
                }
                if(tmp <= min){
                    min = tmp;
                }
            }
        }
        System.out.println(min + " "+ max);
    }
}
