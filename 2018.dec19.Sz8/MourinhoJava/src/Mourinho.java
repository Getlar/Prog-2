import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Pakk implements Comparable<Pakk>{
    int ev;
    List<Edzok> edzok;

    public Pakk(int ev) {
        this.ev = ev;
        this.edzok = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ev).append(":");
        for (Edzok e:edzok
             ) {
            sb.append("\n").append(e.toString());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Pakk o) {
        if(this.ev > o.ev){
            return 1;
        }
        if(this.ev < o.ev){
            return -1;
        }
        return 0;
    }
}
class Edzok implements Comparable<Edzok>{

    String nev;
    String csapat;

    public Edzok(String nev, String csapat) {
        this.nev = nev;
        this.csapat = csapat;
    }

    @Override
    public int compareTo(Edzok o) {
        if (this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if (this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return nev + " (" + csapat + ")";
    }

}
public class Mourinho {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be;
        String[] be2;
        String[] utolso;
        List<Pakk> pakkok = new ArrayList<>();
        Pakk tmp;
        while (sc.hasNextLine()){
            be = sc.nextLine().split(":");
            be2 = be[1].split(";");
            for (String a:be2
                 ) {
                tmp = null;
                utolso = a.split(",");
                for (Pakk p:pakkok
                     ) {
                    if (p.ev == Integer.parseInt(utolso[1])){
                        tmp = p;
                        break;
                    }
                }
                if (tmp == null){
                    pakkok.add(new Pakk(Integer.parseInt(utolso[1])));
                    pakkok.get(pakkok.size()-1).edzok.add(new Edzok(utolso[0], be[0]));
                }else{
                    tmp.edzok.add(new Edzok((utolso[0]), be[0]));
                }
            }
        }
        Collections.sort(pakkok);
        for (Pakk p:pakkok
             ) {
            Collections.sort(p.edzok);
        }
        for (Pakk p:pakkok
             ) {
            System.out.println(p);
        }
    }
}
