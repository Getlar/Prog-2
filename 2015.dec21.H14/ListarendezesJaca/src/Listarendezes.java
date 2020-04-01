import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Koltok{

    String nev;
    int szuletes;
    int elhalalozas;

    public Koltok(String nev, int szuletes, int elhalalozas) {
        this.nev = nev;
        this.szuletes = szuletes;
        this.elhalalozas = elhalalozas;
    }

    @Override
    public String toString() {
        return this.nev + " (" + this.szuletes + "-" + this.elhalalozas + ")";
    }
}

public class Listarendezes {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        List<Koltok> koltok = new ArrayList<>();
        String sor = sc.nextLine();
        while (!Character.isDigit(sor.charAt(0))){
            String[] be = sor.split(";");
            koltok.add(new Koltok(be[0], Integer.parseInt(be[1]), Integer.parseInt(be[2])));
            sor = sc.nextLine();
        }
        for (Koltok k :koltok
             ) {
            System.out.println(k);
        }
        for (int i = 0; i < sor.length(); i++){
            switch (sor.charAt(i)){
                case '0':
                    if (!koltok.isEmpty()){
                        koltok.remove(0);
                    }
                    break;
                case '1':
                    Collections.sort(koltok, (x,y) -> (x.nev.equals(y.nev) ? (x.szuletes == y.szuletes) ? (Integer.compare(x.elhalalozas, y.elhalalozas)):(Integer.compare(x.szuletes, y.szuletes)) : x.nev.compareTo(y.nev)));
                    break;
                case '2':
                    Collections.sort(koltok, (x,y) -> (x.szuletes == y.szuletes) ? (x.elhalalozas == y.elhalalozas) ? (x.nev.compareTo(y.nev)):(Integer.compare(x.elhalalozas,y.elhalalozas)) : (Integer.compare(x.szuletes,y.szuletes)));
                    break;
            }
            System.out.println("---");
            for (Koltok k:koltok
                 ) {
                System.out.println(k);
            }
        }
    }
}
