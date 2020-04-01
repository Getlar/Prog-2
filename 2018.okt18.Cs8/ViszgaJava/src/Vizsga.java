import java.util.Scanner;

public class Vizsga {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be = sc.nextLine().split(" ");
        int meret = be.length;
        int leghosszabb;
        int[] napok = new int[meret];
        for (int i = 0; i < meret; i++){
            napok[i] = Integer.parseInt(be[i]);
        }
        leghosszabb = napok[0];
        for (int i = 0; i < napok.length - 1; i++){
            if ((napok[i + 1] - napok[i]) > leghosszabb){
                leghosszabb = napok[i + 1] - napok[i];
            }
        }
        System.out.println(leghosszabb - 1);

    }
}
