import java.util.Scanner;

public class Valto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = sc.nextInt();
            n = (9 * n)/5 + 32;
            System.out.println(n);
        }
    }
}
