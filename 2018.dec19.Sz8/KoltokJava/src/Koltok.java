import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Pakk implements Comparable<Pakk>{

    String varos;
    int hanyszor;
    List<Nev> nevek;

    public Pakk(String varos) {
        this.varos = varos;
        this.hanyszor = 1;
        this.nevek = new ArrayList<>();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.varos).append(" (").append(this.hanyszor).append("):");
        for (Nev n:nevek
             ) {
            sb.append("\n").append(n.toString());
        }
        return sb.toString();
    }
    public void setHanyszor(){
        this.hanyszor = this.hanyszor + 1;
    }

    @Override
    public int compareTo(Pakk o) {
        if (this.varos.compareTo(o.varos) > 0){
            return 1;
        }
        if (this.varos.compareTo(o.varos) < 0){
            return -1;
        }
        return 0;
    }
}

class Nev implements Comparable<Nev>{

    String nev;

    public Nev(String nev) {
        this.nev = nev;
    }

    @Override
    public String toString() {
        return this.nev;
    }

    @Override
    public int compareTo(Nev o) {
        if (this.nev.compareTo(o.nev) > 0) {
            return 1;
        }
        if (this.nev.compareTo(o.nev) < 0) {
            return -1;
        }
        return 0;
    }
}
public class Koltok {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Pakk> pakkok = new ArrayList<>();
        Pakk tmp;
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(":");
            String[] be2 = be[1].split(",");
            for (String s:be2
                 ) {
                tmp = null;
                int seged = 0;
                String[] utolso = s.split(" ");
                for (Pakk p:pakkok
                     ) {
                    if (p.varos.compareTo(utolso[0]) == 0){
                        tmp = p;
                        break;
                    }
                }
                if (tmp == null){
                    pakkok.add(new Pakk(utolso[0]));
                    pakkok.get(pakkok.size()-1).nevek.add(new Nev(be[0]));
                }else{
                    for (Nev n:tmp.nevek
                         ) {
                        if (n.nev.compareTo(be[0]) == 0){
                            seged = 1;
                            break;
                        }
                    }
                    if (seged == 0){
                        tmp.nevek.add(new Nev(be[0]));
                        tmp.setHanyszor();
                    }
                }
            }
        }
        Collections.sort(pakkok);
        for (Pakk p:pakkok
             ) {
            Collections.sort(p.nevek);
        }
        for (Pakk p:pakkok
             ) {
            System.out.println(p);
        }
    }
}
