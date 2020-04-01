import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RelativP {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> szamok = new ArrayList<>();
        String[] be = sc.nextLine().split(" ");
        int n = Integer.parseInt(be[0]);
        int k = Integer.parseInt(be[1]);
        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            int gcd = 1;
            for (int j = 1; j <= tmp && j <= k; j++){
                if (tmp % j == 0 && k % j == 0){
                    gcd = j;
                }
            }
            if (gcd == 1){
                szamok.add(tmp);
            }
        }
        Collections.sort(szamok);
        for (int l:szamok
             ) {
            System.out.println(l);
        }
    }
}
