import java.util.Arrays;
import java.util.Scanner;

class Kedvezmeny implements Comparable<Kedvezmeny>{

    String mire;
    String hol;
    int mennyi;
    int hasonlito = 0;

    public Kedvezmeny(String mire, String hol, int mennyi) {
        this.mire = mire;
        this.hol = hol;
        this.mennyi = mennyi;
    }

    public String getMire() {
        return mire;
    }

    public void setMire(String mire) {
        this.mire = mire;
    }

    public String getHol() {
        return hol;
    }

    public void setHol(String hol) {
        this.hol = hol;
    }

    public int getMennyi() {
        return mennyi;
    }

    public void setMennyi(int mennyi) {
        this.mennyi = mennyi;
    }

    public int getHasonlito() {
        return hasonlito;
    }

    public void setHasonlito(int hasonlito) {
        this.hasonlito = hasonlito;
    }

    @Override
    public int compareTo(Kedvezmeny o) {
        if (this.hasonlito == 0){
            if (this.mennyi > o.mennyi){
                return -1;
            }
            if (this.mennyi < o.mennyi){
                return 1;
            }
            if (this.hol.compareTo(o.hol) > 0){
                return 1;
            }
            if (this.hol.compareTo(o.hol) < 0){
                return -1;
            }
            if (this.mire.compareTo(o.mire) > 0){
                return 1;
            }
            if (this.mire.compareTo(o.mire) < 0){
                return -1;
            }
        }
        if (this.hasonlito == 1){
            if (this.hol.compareTo(o.hol) > 0){
                return 1;
            }
            if (this.hol.compareTo(o.hol) < 0){
                return -1;
            }
            if (this.mennyi > o.mennyi){
                return -1;
            }
            if (this.mennyi < o.mennyi){
                return 1;
            }
            if (this.mire.compareTo(o.mire) > 0){
                return 1;
            }
            if (this.mire.compareTo(o.mire) < 0){
                return -1;
            }
        }
        return 0;
    }
}

public class Kupon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int l = 0;
        Kedvezmeny[] kedvezmenyek = new Kedvezmeny[n];
        for (int i = 0; i < kedvezmenyek.length; i++){
            String[] be = sc.nextLine().split(";");
            kedvezmenyek[i] = new Kedvezmeny(be[1], be[0], Integer.parseInt(be[2]));
        }

        Arrays.sort(kedvezmenyek);
        for (int i = 0; i < kedvezmenyek.length; i++){
            System.out.println(kedvezmenyek[i].getMire() + " (" + kedvezmenyek[i].getHol() + "): " + kedvezmenyek[i].getMennyi() + "%");
            kedvezmenyek[i].setHasonlito(1);
        }
        Arrays.sort(kedvezmenyek);
        System.out.println();
        for (int i = 0; i < kedvezmenyek.length; i++){
            System.out.println(kedvezmenyek[i].getMire() + " (" + kedvezmenyek[i].getHol() + "): " + kedvezmenyek[i].getMennyi() + "%");
        }
    }
}
