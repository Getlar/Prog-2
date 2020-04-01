import java.util.Arrays;
import java.util.Scanner;
class Tortak implements Comparable<Tortak>{

    String nev;
    int szelet;
    int ar;
    int szeletAr;

    public Tortak(String nev, int szelet, int ar) {
        this.nev = nev;
        this.szelet = szelet;
        this.ar = ar;
        this.szeletAr = ar / szelet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nev).append(" (").append(szelet).append(" szelet): ").append(ar).append(" Ft");
        return sb.toString();
    }

    @Override
    public int compareTo(Tortak o) {
        if (this.szeletAr > o.szeletAr){
            return 1;
        }
        if (this.szeletAr < o.szeletAr){
            return -1;
        }
        if (this.szelet > o.szelet){
            return -1;
        }
        if (this.szelet < o.szelet){
            return 1;
        }
        if (this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if (this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        return 0;
    }
}
public class TortaJava {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Tortak[] tortak = new Tortak[n];
        for (int i = 0; i < tortak.length; i++){
            String[] be = sc.nextLine().split(":");
            tortak[i] = new Tortak(be[0], Integer.parseInt(be[1]), Integer.parseInt(be[2]));
        }
        Arrays.sort(tortak);
        for (Tortak t:tortak
             ) {
            System.out.println(t);
        }
    }
}
