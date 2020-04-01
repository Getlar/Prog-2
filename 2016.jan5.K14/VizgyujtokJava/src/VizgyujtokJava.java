import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Vizgyujto{
    String nev;
    List<Vizgyujto> befolyok;
    public Vizgyujto(String nev) {
        this.nev = nev;
        this.befolyok = new ArrayList<>();
    }
    public int befolyokszama(){
        return befolyok.size();
    }
    public Vizgyujto kereso(Vizgyujto v, String nev){
        for (Vizgyujto s: v.befolyok
             ) {
            if (s.nev.compareTo(nev) == 0){
                return v;
            }else{
                s.kereso(s,nev);
            }
        }
        return null;
    }
    public void gyujti (Vizgyujto v){
        if (!this.befolyok.contains(v)){
            this.befolyok.add(v);
        }
        if (v.nev.compareTo(this.nev) != 0) {
            for (Vizgyujto l : v.befolyok
            ) {
                gyujti(l);
                if (!this.befolyok.contains(l)) {
                    this.befolyok.add(l);
                }
            }
        }
    }
    @Override
    public String toString() {
        return this.nev + ": " + befolyokszama();
    }
}
public class VizgyujtokJava {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Vizgyujto> vizsgyujtok = new ArrayList<>();
        Vizgyujto tmp1;
        Vizgyujto tmp2;
        Vizgyujto tmp3;
        List<Vizgyujto> tilosak = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] be = sc.nextLine().split(";");
            if (be.length == 2) {
                int tilose = 0;
                for (Vizgyujto o:tilosak
                     ) {
                    if (o.nev.compareTo(be[0]) == 0){
                        tilose = 1;
                    }
                }
                if (tilose == 0) {
                    if (vizsgyujtok.size() == 0) {
                        vizsgyujtok.add(new Vizgyujto(be[0]));
                        vizsgyujtok.add(new Vizgyujto(be[1]));
                        vizsgyujtok.get(vizsgyujtok.size() - 1).befolyok.add(vizsgyujtok.get(vizsgyujtok.size() - 2));
                    } else {
                        tmp1 = null;
                        tmp2 = null;
                        for (Vizgyujto v : vizsgyujtok
                        ) {
                            if (v.nev.compareTo(be[0]) == 0) {
                                tmp1 = v;
                                break;
                            }
                        }
                        for (Vizgyujto v : vizsgyujtok
                        ) {
                            if (v.nev.compareTo(be[1]) == 0) {
                                tmp2 = v;
                                break;
                            }
                        }
                        if (tmp1 == null && tmp2 == null) {
                            vizsgyujtok.add(new Vizgyujto(be[0]));
                            vizsgyujtok.add(new Vizgyujto(be[1]));
                            vizsgyujtok.get(vizsgyujtok.size() - 1).befolyok.add(vizsgyujtok.get(vizsgyujtok.size() - 2));

                        } else if (tmp1 == null) {
                            vizsgyujtok.add(new Vizgyujto(be[0]));
                            tmp2.befolyok.add(vizsgyujtok.get(vizsgyujtok.size() - 1));
                            for (Vizgyujto v : vizsgyujtok
                            ) {
                                if (v.kereso(v, tmp2.nev) != null) {
                                    tmp3 = v.kereso(v, tmp2.nev);
                                    if (tmp3.nev.compareTo(tmp2.nev) != 0) {
                                        tmp3.gyujti(tmp2);
                                    }
                                }
                            }
                        } else if (tmp2 == null) {
                            vizsgyujtok.add(new Vizgyujto(be[1]));
                            vizsgyujtok.get(vizsgyujtok.size() - 1).gyujti(tmp1);

                        } else {
                            tmp2.gyujti(tmp1);
                            for (Vizgyujto v : vizsgyujtok
                            ) {
                                if (v.kereso(v, tmp2.nev) != null) {
                                    tmp3 = v.kereso(v, tmp2.nev);
                                    if (tmp3.nev.compareTo(tmp2.nev) != 0) {
                                        tmp3.gyujti(tmp2);
                                    }
                                }
                            }
                        }
                    }
                }else{
                    ;
                }
            }else {
                vizsgyujtok.add(new Vizgyujto(be[0]));
                tilosak.add(new Vizgyujto(be[0]));
            }
        }
        for (int i = 0; i < args.length; i++){
            int seged = 0;
            for (Vizgyujto v:vizsgyujtok
                 ) {
                if (v.nev.compareTo(args[i]) == 0 ){
                    System.out.println(v.toString());
                    seged = 1;
                    break;
                }
            }
            if (seged == 0){
                System.out.println(args[i] + ": " + 0);
            }
        }
    }
}
