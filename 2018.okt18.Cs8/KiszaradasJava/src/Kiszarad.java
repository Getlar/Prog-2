import java.util.Scanner;

public class Kiszarad {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be = sc.nextLine().split(" ");
        int tav = Integer.parseInt(be[0]);
        int benzin = Integer.parseInt(be[1]);
        int tankolasSzama = Integer.parseInt(be[2]);
        int fogyasztas = Integer.parseInt(be[3]);
        int hanyszor = 0;
        int benzinallas = benzin;
        int elozo = 0;
        int allas = 0;
        for (int i = 0; i < tankolasSzama; i++){
            String be2[] = sc.nextLine().split(" ");
            int mennyit = Integer.parseInt(be2[0]);
            int vissza = Integer.parseInt(be2[1]);
            allas = elozo - mennyit;
            elozo = mennyit;
            if (benzinallas > benzinallas - Math.abs(allas) * fogyasztas + vissza){
                hanyszor++;
            }
            benzinallas = benzinallas - Math.abs(allas) * fogyasztas + vissza;
        }
        System.out.println(hanyszor);

    }
}
