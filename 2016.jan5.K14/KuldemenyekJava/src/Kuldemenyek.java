import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Pakk implements Comparable<Pakk>{
    int iranyitoszam;
    int osszertek;
    List <Kuldemeny> csomagok;

    public Pakk(int iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
        this.osszertek = 0;
        this.csomagok = new ArrayList<>();
    }
    public void setOsszertek(){
        this.osszertek = 0;
        for (Kuldemeny k:csomagok
             ) {
            osszertek += k.ertek;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(iranyitoszam).append(": ").append(osszertek).append(" Ft");
        for (Kuldemeny k: csomagok
             ) {
            sb.append("\n").append(k.toString());
        }
        return sb.toString();
    }
    @Override
    public int compareTo(Pakk o) {
        if (this.iranyitoszam > o.iranyitoszam){
            return 1;
        }
        if (this.iranyitoszam < o.iranyitoszam){
            return -1;
        }
        return 0;
    }
}
class Kuldemeny implements Comparable<Kuldemeny>{

    String cimzett;
    String telepules;
    String utca;
    int hazszam;
    int ertek;
    public Kuldemeny(String cimzett, String telepules, String utca, int hazszam, int ertek) {
        this.cimzett = cimzett;
        this.telepules = telepules;
        this.utca = utca;
        this.hazszam = hazszam;
        this.ertek = ertek;
    }
    @Override
    public String toString() {
        return telepules + " , " + utca + " " + hazszam + "., " + cimzett + ", " + ertek + " Ft";
    }
    @Override
    public int compareTo(Kuldemeny o) {
        if (this.telepules.compareTo(o.telepules) > 0){
            return 1;
        }
        if (this.telepules.compareTo(o.telepules) < 0){
            return -1;
        }
        if (this.utca.compareTo(o.utca) > 0){
            return 1;
        }
        if (this.utca.compareTo(o.utca) < 0){
            return -1;
        }
        if (this.hazszam > o.hazszam){
            return 1;
        }
        if (this.hazszam < o.hazszam){
            return -1;
        }
        if (this.cimzett.compareTo(o.cimzett) > 0){
            return 1;
        }
        if (this.cimzett.compareTo(o.cimzett) < 0){
            return -1;
        }
        if (this.ertek > o.ertek){
            return -1;
        }
        if (this.ertek < o.ertek){
            return 1;
        }
        return 0;
    }
}
public class Kuldemenyek {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("kuldemenyek.txt"));
        String[] sor;
        List<Pakk> pakk = new ArrayList<>();
        Pakk tmp;
        int irsz;
        while (sc.hasNextLine()){
            sor = sc.nextLine().split(":");
            tmp = null;
            irsz = Integer.parseInt(sor[1]);
            for (Pakk p:pakk
                 ) {
                if (p.iranyitoszam == irsz){
                    tmp = p;
                    break;
                }
            }
            if (tmp == null){
                pakk.add(new Pakk(irsz));
                pakk.get(pakk.size()-1).csomagok.add(new Kuldemeny(sor[0], sor[2], sor[3], Integer.parseInt(sor[4]), Integer.parseInt(sor[5])));
            }else{
                tmp.csomagok.add(new Kuldemeny(sor[0], sor[2], sor[3], Integer.parseInt(sor[4]), Integer.parseInt(sor[5])));
            }
        }
        for (Pakk p: pakk
             ) {
            p.setOsszertek();
        }
        Collections.sort(pakk);
        for (Pakk p:pakk
             ) {
            Collections.sort(p.csomagok);
        }
        for (Pakk p:pakk
             ) {
            System.out.println(p);
        }
    }
}
