import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Lanyok implements Comparable<Lanyok>{
    String nev;
    List<Ev> evek;

    public Lanyok(String nev) {
        this.nev = nev;
        this.evek = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nev).append(":");
        for (Ev e:evek
             ) {
            if (evek.get(evek.size()-1).ev == e.ev){
                sb.append(e.toString());
            }else{
                sb.append(e.toString()).append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Lanyok o) {
        if (this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if (this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        return 0;
    }
}
class Ev implements Comparable<Ev>{
    int ev;

    public Ev(int ev) {
        this.ev = ev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ev);
        return sb.toString();
    }

    @Override
    public int compareTo(Ev o) {
        if (this.ev > o.ev){
            return 1;
        }
        if (this.ev < o.ev){
            return -1;
        }
        return 0;
    }
}
public class Angyalka {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Lanyok> pakkok = new ArrayList<>();
        Lanyok tmp;
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(":");
            String[] utolso = be[1].split(",");
            for (String s:utolso
                 ) {
                tmp = null;
                for (Lanyok l:pakkok
                     ) {
                    if (l.nev.compareTo(s) == 0){
                        tmp = l;
                        break;
                    }
                }
                if (tmp == null){
                    pakkok.add(new Lanyok(s));
                    pakkok.get(pakkok.size()-1).evek.add(new Ev(Integer.parseInt(be[0])));
                }else{
                    tmp.evek.add(new Ev(Integer.parseInt(be[0])));
                }
            }
        }
        Collections.sort(pakkok);
        for (Lanyok l:pakkok
             ) {
            Collections.sort(l.evek);
        }
        for (Lanyok l:pakkok
             ) {
            System.out.println(l);
        }
    }
}
