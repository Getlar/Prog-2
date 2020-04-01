import java.util.Arrays;
import java.util.Scanner;

class Emberek implements Comparable<Emberek>{

    String nev;
    int szavazat;

    public Emberek(String nev, int szavazat) {
        this.nev = nev;
        this.szavazat = szavazat;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzavazat() {
        return szavazat;
    }

    public void setSzavazat(int szavazat) {
        this.szavazat = szavazat;
    }

    @Override
    public int compareTo(Emberek o) {
        if(this.szavazat > o.szavazat){
            return -11;
        }
        if(this.szavazat < o.szavazat){
            return 1;
        }
        if(this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if(this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        return 0;
    }
}


public class Pokember {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Emberek[] emberek = new Emberek[n];
        for (int i = 0; i < emberek.length; i++){
            String[] be = sc.nextLine().split(":");
            int mennyi = be[1].length() - be[1].replaceAll("#","").length();
            emberek[i] = new Emberek(be[0], mennyi);
        }
        Arrays.sort(emberek);
        System.out.println(emberek[0].getNev());
        int i = 1;
        while (emberek[i].getSzavazat() == emberek[0].getSzavazat()){
            System.out.println(emberek[i].getNev());
            i++;
        }
    }
}
