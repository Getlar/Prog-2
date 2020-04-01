import java.util.Scanner;

public class Csepp {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        int kilometer, benzin, tankolasSzama, fogyasztas;
        int tmp1, tmp2;
        int maradek;
        kilometer = sc.nextInt();
        benzin = sc.nextInt();
        tankolasSzama = sc.nextInt();
        fogyasztas = sc.nextInt();
        maradek = benzin - kilometer * fogyasztas;
        while(sc.hasNext()){
            tmp1 = sc.nextInt();
            tmp2 = sc.nextInt();
            maradek = maradek + tmp2;
        }
        System.out.println(maradek);
    }
}
