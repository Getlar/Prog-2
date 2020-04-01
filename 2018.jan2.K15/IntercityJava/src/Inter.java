import java.util.*;

class Pakk implements Comparable<Pakk>{
    String allomasNeve;
    List<Megallok> megallok;

    public Pakk(String allomasNeve) {
        this.allomasNeve = allomasNeve;
        this.megallok = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.allomasNeve).append(":");
        for (Megallok m:megallok
             ) {
            sb.append("\n").append(m.toString());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Pakk o) {
        if (this.allomasNeve.compareTo(o.allomasNeve) > 0){
            return 1;
        }
        if (this.allomasNeve.compareTo(o.allomasNeve) < 0){
            return -1;
        }
        return 0;
    }
}
class Megallok implements Comparable<Megallok>{

    String ora;
    String perc;
    String vonatNeve;
    String merreTart;

    public Megallok(String ora, String perc, String vonatNeve, String merreTart) {
        this.ora = ora;
        this.perc = perc;
        this.vonatNeve = vonatNeve;
        this.merreTart = merreTart;
    }

    @Override
    public String toString() {
        return this.ora + "." + this.perc + ": " + this.vonatNeve + " (" + this.merreTart + ")";
    }

    @Override
    public int compareTo(Megallok o) {
        if (Integer.parseInt(this.ora) > Integer.parseInt(o.ora)){
            return 1;
        }
        if (Integer.parseInt(this.ora) < Integer.parseInt(o.ora)){
            return -1;
        }
        if (Integer.parseInt(this.perc) > Integer.parseInt(o.perc)){
            return 1;
        }
        if (Integer.parseInt(this.perc) < Integer.parseInt(o.perc)){
            return -1;
        }
        if (this.vonatNeve.compareTo(o.vonatNeve) > 0){
            return 1;
        }
        if (this.vonatNeve.compareTo(o.vonatNeve) < 0){
            return -1;
        }
        return 0;
    }
}


public class Inter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Pakk tmp;
        int n = Integer.parseInt(sc.nextLine());
        List<Pakk> pakkok =  new ArrayList<>();
        List<String[]> megallok = new ArrayList<>();
        for (int i = 0; i < n; i++){
            megallok.add(sc.nextLine().split(";"));
        }
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(";");
            String[] szamok = be[3].split("\\.");
            for (int i = 0; i < megallok.size(); i++){
                if (be[0].compareTo(megallok.get(i)[0]) == 0){
                    tmp = null;
                    for (Pakk p:pakkok
                         ) {
                        if (be[2].compareTo(p.allomasNeve) == 0){
                            tmp = p;
                            break;
                        }
                    }
                    if (tmp == null){
                        pakkok.add(new Pakk(be[2]));
                        pakkok.get(pakkok.size()-1).megallok.add(new Megallok(szamok[0], szamok[1], megallok.get(i)[1], megallok.get(i)[3]));
                    }else{
                        tmp.megallok.add(new Megallok(szamok[0], szamok[1], megallok.get(i)[1], megallok.get(i)[3]));
                    }
                }
            }
        }
        Collections.sort(pakkok);
        for (Pakk p:pakkok
             ) {
            Collections.sort(p.megallok);
        }
        for (Pakk p:pakkok
             ) {
            System.out.println(p);
        }
    }
}
