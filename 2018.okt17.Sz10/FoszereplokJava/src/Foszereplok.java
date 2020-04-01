import java.util.Arrays;
import java.util.Scanner;
class Konyvek implements Comparable<Konyvek>{

    String nev;
    int foszereplok;

    public Konyvek(String nev, int foszereplok) {
        this.nev = nev;
        this.foszereplok = foszereplok;
    }

    @Override
    public int compareTo(Konyvek o) {
        if(this.nev.compareTo(o.nev) > 0)
            return 1;
        if(this.nev.compareTo(o.nev) < 0)
            return -1;
        return 0;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getFoszereplok() {
        return foszereplok;
    }

    public void setFoszereplok(int foszereplok) {
        this.foszereplok = foszereplok;
    }
}
public class Foszereplok {
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        String[] szamok = sc.nextLine().split(" ");
        int k = Integer.parseInt(szamok[0]);
        int l = Integer.parseInt(szamok[1]);
        String akt;
        Konyvek[] konyvek = new Konyvek[k];
        for (int i = 0; i < konyvek.length; i++){
            String vesszo = ",";
            String pont = ":";
            akt = sc.nextLine().replaceAll(vesszo,pont);
            String[] nagy = akt.split(pont);
            konyvek[i] = new Konyvek(nagy[0],nagy.length-1);
        }
        Arrays.sort(konyvek);
        for(int i = 0; i < konyvek.length; i++){
            if(konyvek[i].getFoszereplok() == l) {
                System.out.println(konyvek[i].getNev());
            }
        }
    }
}
