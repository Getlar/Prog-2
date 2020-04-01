import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Utca implements Comparable<Utca>{

    String nev;
    int hanyszor;

    public Utca(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getHanyszor() {
        return hanyszor;
    }

    public void setHanyszor(int hanyszor) {
        this.hanyszor = hanyszor;
    }

    @Override
    public int compareTo(Utca o) {
        if (this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if (this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        return 0;
    }
}

public class Butor {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = 0, kapcsolo = 0, j;
        ArrayList<Utca> utcak = new ArrayList<Utca>();
        for (int i = 0; i < n; i++){
            String[] be = sc.nextLine().split(":");
            if (i == 0){
                utcak.add(new Utca(be[1]));
                utcak.get(m).setHanyszor(1);
            }else {
                kapcsolo = 0;
                for (j = 0; j < m + 1; j++) {
                    if ((utcak.get(j).getNev()).equals(be[1])) {
                        utcak.get(j).setHanyszor(utcak.get(j).getHanyszor() + 1);
                        kapcsolo = 1;
                        break;
                    }
                }
                if (kapcsolo == 0) {
                    m++;
                    utcak.add(new Utca(be[1]));
                    utcak.get(m).setHanyszor(1);
                }
            }
        }
        Collections.sort(utcak);
        for (int i = 0; i < m+1; i++){
            System.out.println(utcak.get(i).getNev() + " - " + utcak.get(i).getHanyszor() + " darab");
        }
    }
}
