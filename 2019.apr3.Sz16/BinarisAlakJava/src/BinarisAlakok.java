import java.util.Scanner;

public class BinarisAlakok {
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        int szamos;
        while (sc.hasNextLine()){
            n = Integer.parseInt(sc.nextLine());
            szamos = 0;
            while(n != 0){
                if(n % 2 == 1){
                    szamos++;
                }
                n = n/2;
            }
            System.out.println(szamos);
        }
    }
}
