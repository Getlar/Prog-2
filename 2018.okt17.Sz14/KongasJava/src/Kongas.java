import java.util.Scanner;

public class Kongas {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tav, benzin, tankolasSzama, fogyasztas, max, allas = 0, elozo = 0;
        String[] be = sc.nextLine().split(" ");
        tav = Integer.parseInt(be[0]);
        benzin = Integer.parseInt(be[1]);
        tankolasSzama = Integer.parseInt(be[2]);
        fogyasztas = Integer.parseInt(be[3]);
    max = benzin;
        for (int i = 0; i < tankolasSzama; i++){
        String[] akt = sc.nextLine().split(" ");
        if(Integer.parseInt(akt[0]) > tav){
            System.exit(1);
        }
        allas = elozo - Integer.parseInt(akt[0]);
        elozo = Integer.parseInt(akt[0]);
        if(Math.abs(allas) * fogyasztas > benzin){
            System.exit(1);
        }
        benzin = benzin - fogyasztas * Math.abs(allas) + Integer.parseInt(akt[1]);
        if (benzin > max) {
            max = benzin;
        }
    }
            System.out.println(max);
}
}
