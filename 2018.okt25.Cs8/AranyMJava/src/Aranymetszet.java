import java.util.Arrays;
import java.util.Scanner;

class Emberek implements Comparable<Emberek>{

    private String nev;
    private double szamlalo;
    private double nevezo;
    private double metszet;
    private double aranym;
    private double kozelites = Math.abs(aranym - metszet);

    public Emberek(String nev, double szamlalo, double nevezo) {
        this.nev = nev;
        this.szamlalo = szamlalo;
        this.nevezo = nevezo;
        this.metszet = szamlalo / nevezo;
        this.aranym = (1 + Math.sqrt(5))/2;
        this.kozelites = Math.abs(this.aranym - this.metszet);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public double getSzamlalo() {
        return szamlalo;
    }

    public void setSzamlalo(int szamlalo) {
        this.szamlalo = szamlalo;
    }

    public double getNevezo() {
        return nevezo;
    }

    public void setNevezo(int nevezo) {
        this.nevezo = nevezo;
    }

    public double getMetszet() {
        return metszet;
    }

    public void setMetszet(double metszet) {
        this.metszet = metszet;
    }

    public void setSzamlalo(double szamlalo) {
        this.szamlalo = szamlalo;
    }

    public double getAranym() {
        return aranym;
    }

    public void setAranym(double aranym) {
        this.aranym = aranym;
    }

    public void setNevezo(double nevezo) {
        this.nevezo = nevezo;
    }

    public double getKozelites() {
        return kozelites;
    }

    public void setKozelites(double kozelites) {
        this.kozelites = kozelites;
    }

    @Override
    public int compareTo(Emberek o) {
        if (this.kozelites > o.kozelites){
            return 1;
        }
        if (this.kozelites < o.kozelites){
            return -1;
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

public class Aranymetszet {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Emberek[] emberek = new Emberek[n];
        for (int i = 0; i < emberek.length; i++){
            String[] be = sc.nextLine().split(":");
            emberek[i] = new Emberek(be[0], Double.parseDouble(be[1]), Double.parseDouble(be[2]));
        }
        Arrays.sort(emberek);
        for (int i = 0; i < emberek.length; i++){
            System.out.println(emberek[i].getNev() + ": " + (int)emberek[i].getSzamlalo() + "/" + (int)emberek[i].getNevezo());
        }
    }
}
