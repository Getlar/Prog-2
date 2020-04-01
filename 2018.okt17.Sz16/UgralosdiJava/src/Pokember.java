import java.util.Arrays;
import java.util.Scanner;
class Hazak implements Comparable<Hazak>{

    int sorszam;
    int meret;

    public Hazak(int sorszam, int meret) {
        this.sorszam = sorszam;
        this.meret = meret;
    }

    public int getSorszam() {
        return sorszam;
    }

    public void setSorszam(int sorszam) {
        this.sorszam = sorszam;
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }

    @Override
    public int compareTo(Hazak o) {
        if(this.sorszam > o.sorszam){
            return 1;
        }
        if(this.sorszam < o.sorszam){
            return -1;
        }
        return 0;
    }
}
public class Pokember {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be = sc.nextLine().split(" ");
        int n = Integer.parseInt(be[0]);
        int k = Integer.parseInt(be[1]);
        int szamlalo = 0;
        int j;
        Hazak[] hazak = new Hazak[n];
        for (int i = 0; i < hazak.length; i++){
            String[] be2 = sc.nextLine().split(" ");
            hazak[i] = new Hazak(Integer.parseInt(be2[0]), Integer.parseInt(be2[1]));
        }
        Arrays.sort(hazak);
        for (int i = 0; i < hazak.length; i++){
            if(hazak[i].getMeret() >= k){
                szamlalo++;
            }
        }
        System.out.println(szamlalo);
    }
}
