import java.util.Arrays;
import java.util.Scanner;

class Rendszam implements Comparable<Rendszam>{

    int evszam;
    String haromszam;
    String rendszam;
    String marka;

    public Rendszam(int evszam, String haromszam, String rendszam, String marka) {
        this.evszam = evszam;
        this.haromszam = haromszam;
        this.rendszam = rendszam;
        this.marka = marka;
    }

    public int getEvszam() {
        return evszam;
    }

    public void setEvszam(int evszam) {
        this.evszam = evszam;
    }

    public String getHaromszam() {
        return haromszam;
    }

    public void setHaromszam(String haromszam) {
        this.haromszam = haromszam;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return haromszam + "-" + rendszam + " " + marka + " " + "(" + evszam + ")";
    }

    @Override
    public int compareTo(Rendszam o) {
        if (this.haromszam.compareTo(o.haromszam) > 0)
            return 1;
        if (this.haromszam.compareTo(o.haromszam) < 0)
            return -1;
        if (this.rendszam.compareTo(o.rendszam) > 0)
            return 1;
        if (this.rendszam.compareTo(o.rendszam) < 0)
            return -1;
        if (this.marka.compareTo(o.marka) > 0)
            return 1;
        if (this.marka.compareTo(o.marka) < 0)
            return -1;
        if (this.evszam > o.evszam)
            return 1;
        if (this.evszam < o.evszam)
            return -1;
        return 0;
    }
}

public class Rendszamok {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Rendszam[] rendszam = new Rendszam[n];
        String darab;
        for(int i = 0 ; i < rendszam.length ; i++){
            String vonal = "-";
            String pont = ":";
            darab = sc.nextLine().replaceAll(vonal,pont);
            String[] nagy = darab.split(pont);
            int l = Integer.parseInt(nagy[2]);
            rendszam[i] = new Rendszam(l,nagy[1],nagy[0],nagy[3]);
        }
        Arrays.sort(rendszam);

        for (int i = 0; i < rendszam.length; i++){
            System.out.println(rendszam[i].toString());
        }
    }
}
