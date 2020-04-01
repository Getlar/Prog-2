import java.util.Arrays;
import java.util.Scanner;
class Diak implements Comparable<Diak>{

    String nev;
    int pontszam;

    public Diak(String nev, int pontszam) {
        this.nev = nev;
        this.pontszam = pontszam;
    }

    @Override
    public int compareTo(Diak o) {
        if (this.pontszam > o.pontszam){
            return -1;
        }
        if (this.pontszam < o.pontszam){
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

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getPontszam() {
        return pontszam;
    }

    public void setPontszam(int pontszam) {
        this.pontszam = pontszam;
    }
}
public class Minden {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be = sc.nextLine().split(" ");
        int n = Integer.parseInt(be[0]);
        int k1 = Integer.parseInt(be[1]);
        int k2 = Integer.parseInt(be[2]);
        int k3 = Integer.parseInt(be[3]);
        int k4 = Integer.parseInt(be[4]);
        Diak[] diakok = new Diak[n];
        for (int i = 0; i < diakok.length; i++){
            String pont = ":";
            String vesszo = ",";
            String benagy = sc.nextLine().replaceAll(pont, vesszo);
            String[] be2 = benagy.split(vesszo);
            int pontok = 0;
            for (int j = 1; j < be2.length; j++){
                pontok = pontok + Integer.parseInt(be2[j]);
            }
            diakok[i] = new Diak(be2[0], pontok);
        }
        Arrays.sort(diakok);
        for (int i = 0; i < diakok.length; i++){
            if (diakok[i].getPontszam() < k1 && diakok[i].getPontszam() >= k2){
                System.out.println(diakok[i].getNev() + " (" + diakok[i].getPontszam() + ")");
            }
        }
    }
}
