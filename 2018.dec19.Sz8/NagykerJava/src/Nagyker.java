import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Pakk implements Comparable<Pakk>{
    String termek;
    List<Boltok> boltok;
    int osszertek;

    public Pakk(String termek) {
        this.termek = termek;
        this.boltok = new ArrayList<>();
        this.osszertek = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.termek).append(" (").append(this.osszertek).append("):");
        for (Boltok b:boltok
             ) {
            sb.append("\n").append(b.boltNeve);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Pakk o) {
        if (this.osszertek > o.osszertek){
            return -1;
        }
        if (this.osszertek < o.osszertek){
            return 1;
        }
        if (this.termek.compareTo(o.termek) > 0){
            return 1;
        }
        if (this.termek.compareTo(o.termek) < 0){
            return -1;
        }
        return 0;
    }
    public void setOsszertek(){
        this.osszertek = 0;
        for (Boltok b:boltok
             ) {
            osszertek += b.mennyi;
        }
    }


}
class Boltok implements Comparable<Boltok>{

    String boltNeve;
    int mennyi;

    public Boltok(String boltNeve, int mennyi) {
        this.boltNeve = boltNeve;
        this.mennyi = mennyi;
    }

    @Override
    public int compareTo(Boltok o) {
        if (this.boltNeve.compareTo(o.boltNeve) > 0){
            return 1;
        }
        if (this.boltNeve.compareTo(o.boltNeve) < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.boltNeve;
    }
}
public class Nagyker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Pakk> pakkok = new ArrayList<>();
        Pakk tmp;
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(":");
            tmp = null;
            String[]be2 = be[1].split(";");
            for (String s:be2
                 ) {
                String[] utolso = s.split(",");
                for (Pakk p:pakkok
                     ) {
                    if (p.termek.compareTo(be[0]) == 0){
                        tmp = p;
                        break;
                    }
                }
                if (tmp == null){
                    pakkok.add(new Pakk(be[0]));
                    pakkok.get(pakkok.size()-1).boltok.add(new Boltok(utolso[0], Integer.parseInt(utolso[1])));
                }else{
                    tmp.boltok.add(new Boltok(utolso[0], Integer.parseInt(utolso[1])));
                }
            }
        }
        for (Pakk p:pakkok
             ) {
            p.setOsszertek();
        }
        Collections.sort(pakkok);
        for (Pakk p:pakkok
             ) {
            Collections.sort(p.boltok);
        }
        System.out.println(pakkok.get(0));
        for (int i = 1; i < pakkok.size(); i++){
            if (pakkok.get(0).osszertek == pakkok.get(i).osszertek){
                System.out.println(pakkok.get(i));
            }
        }
    }
}
