import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Molekulak implements Comparable<Molekulak>{
    // ez az osztaly fogja tarolni a feladat molekulait
    String molekula;
    List<Elemek> elemek;
    // a molekulanak lesz 1 neve es tobb atomja
    // ezt egy olyan listaval oldjuk meg amik Elemek tipusu peldanyokat tartalmaz, tehat atomokat

    public Molekulak(String molekula) {
        this.molekula = molekula;
        this.elemek = new ArrayList<>();
    }
    //konstruktor, ha meghivjuk peldanyositja a listankat
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.molekula).append(":");
        for (Elemek e:elemek
             ) {
            sb.append("\n").append(e.toString());
        }
        return sb.toString();
    }
    //kiiratasnal ez lesz felelos a molekula kiiratasaert majd minden atom eseten meghivja az atom toString-jet

    @Override
    public int compareTo(Molekulak o) {
        if (this.molekula.compareTo(o.molekula) > 0)
        {
            return 1;
        }
        if (this.molekula.compareTo(o.molekula) < 0)
        {
            return -1;
        }
        return 0;
    }
    // Hasonlito fuggveny ami a molekulakat lexikografikus sorrendbe allitja
}
class Elemek implements Comparable<Elemek>{
    // ebbe fogjuk eltarolni a hasznalhato atomokat
    // es szinten ilyen osztalyba fogjuk tarolni a molekulak atomjait
    String vegyjel;
    String elem;
    int hanyszor;
    // H , hidrogen, elofordulas

    public Elemek(String elem, String vegyjel) {
        this.elem = elem;
        this.hanyszor = 1;
        this.vegyjel = vegyjel;
    }
    // konstruktor, ha meghivjuk az elofordulast allitsa 1-re

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hanyszor).append(" ").append(this.elem);
        return sb.toString();
    }
    // ez a toString lesz felelos a molekulan beluli sorok kiiratasara. Pl: 1 hidrogen

    public void setHanyszor(){
        this.hanyszor++;
    }
    // ez a fuggveny fogja novelni az elofordulast 1-gyel

    @Override
    public int compareTo(Elemek o) {
        if (this.hanyszor > o.hanyszor){
            return -1;
        }
        if (this.hanyszor < o.hanyszor){
            return 1;
        }
        if (this.elem.compareTo(o.elem) > 0){
            return 1;
        }
        if (this.elem.compareTo(o.elem) < 0){
            return -1;
        }
        return 0;
    }
    // Hasonlito fuggveny elofordulas szerint majd elemek neveinek lexikografikus sorrendje szerint
}
public class AlakulaPulamula {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Ezzel fogunk beolvasni
        List<Molekulak> molekulak = new ArrayList<>();
        //Listat fogunk csinalni, mivel nem tudjuk elore, hogy hany molekulaval fogunk dolgozni
        //Ha tudnank irhatnank egy olyat, hogy "Molekulak[] molekulak = new Molekulak[n]" , ahol n a darabszam
        //Ez a lista a Molekula osztaly peldanyait fogja tarolni
        List<Elemek> elemek = new ArrayList<>();
        //Ez a lista pedig a lehetseges atomokat fogja eltarolni. Pl : H:hidrogen, Cl:klor stb.
        //Itt se tudjuk hany fog bejonni, szoval ujra listat kell hasznalni
        Elemek tmp;
        //Elemek osztaly tipusu valtozo
        String befele = sc.nextLine();
        //Ezzel fogunk sorokat beolvasni
        while (!befele.contains("-")){
            //Addig olvasson be sorokat amig a "-" sztringet nem olvassa
            String[] be = befele.split(":");
            //Spliteljuk a sort. Pl: H:hidrogenbol lesz H es hidrogen
            elemek.add(new Elemek(be[1], be[0]));
            //Az elemek listahoz hozzaadunk egy Elemek tipusu peldanyt aminek atadjuk a vegyjelet es az atom nevet
            befele = sc.nextLine();
        }
        //Ezzel azt ertuk el, hogy lesz egy listank amibe el van tarolva az osszes lehetseges atom es neki a vegyjelek
        //Azert kellett mert a kovetkezo sorokba pl: 'H'-t fogunk olvasni nem lesz honnan tudjuk hogy a H atomhoz milyen nev tarsul
        while (sc.hasNextLine()){
            //EOF-ig olvasunk
            String[] be2 = sc.nextLine().split(":");
            // Spliteljuk a sort 2 reszre : molekula es atomok;
            String[] utolso = be2[1].split(",");
            // Atomokat is spliteljuk, hogy tudjunk mindegyikre kulon hivatkozni
            // Ez majd azert fog kelleni, hogy meg tudjuk nezni hany darab van egy bizonyos atombol
            molekulak.add(new Molekulak(be2[0]));
            // Minden sorba uj molekulat kapunk, szoval a molekulak listaba belerakunk egy Molekulak peldanyt, ami csak a molekula neve lesz
            for (int i = 0; i < utolso.length; i++){
                // ezzel a for ciklussal fogunk vegigmenni az atomokon pl: H O H
                for (int j = 0; j < elemek.size(); j++){
                    // ezzel a for ciklussal pedig vegigmegyunk az osszes lehetseges atomon amit az elozo while-ba beolvastunk
                    tmp = null;
                    // tmp referencia valtozot null-ra allitjuk kesobb fog kelleni
                    if (elemek.get(j).vegyjel.compareTo(utolso[i]) == 0){
                        // ha megtalaltuk az elemek listaba azt az atomot amit beolvastunk, akkor
                        if (molekulak.get(molekulak.size()-1).elemek.size() == 0){
                            // mar van a molekulak listaba egy peldanyunk, maga a molekula, aminek eltaroltuk a nevet
                            // de ebben az osztalyban talalhato egy lista is ami Elemek tipusu peldanyokat fog tarolni
                            // igy egyes molekulahoz tobb atomot is tudunk ugymond "parositani"
                            // pl: a molekulak listaban a viznek lesz egy neve es atomjai amiket egy ujabb listaban fogunk tarolni
                            // ez a lista pedig el fogja tarolni a vegyjelet az atomnak, a nevet es azt hogy hanyszor fordul elo
                            // a molekulak.get(molekulak.size()-1) az lenyegeben a molekulak lista utolso eleme
                            // ez esetben a nulladik lesz mert csak egy molekulank van az a viz
                            molekulak.get(molekulak.size()-1).elemek.add(new Elemek(elemek.get(j).elem, elemek.get(j).vegyjel));
                            // a molekulan belul lesz nevunk de meg a lista ures, ezert hozzaadjuk az elso atomot az elemek listahoz

                        }
                        else{
                            // ha mar egy atomunk van, tudunk vizsgalni ismetlodeseket, mint viz eseten a ket hidrogen
                            int seged;
                            for (seged = 0; seged < molekulak.get(molekulak.size()-1).elemek.size(); seged++) {
                                // egy segedvaltozo segitsegevel vegigmegyunk az adott molekulan beluli lista elemein
                                if (utolso[i].compareTo(molekulak.get(molekulak.size()-1).elemek.get(seged).vegyjel) == 0) {
                                    // ha talalunk olyan vegyjelet ami mar szerepel a listaban
                                    tmp = molekulak.get(molekulak.size()-1).elemek.get(seged);
                                    // atadjuk ennek a referenciavaltozonak a vizsgalt molekulanak azon listan beluli Elemek tipusu peldany referenciajat
                                    // ahol ismetlodest talaltunk
                                    // Ezzel a tmp - vel most az adott molekulan beluli atom listanak azt az elemet tudjuk elerni amivel utkozest talaltunk
                                    break;
                                    // ha talalt egy ismetlodest ujabb ugyse lesz szoval kibreakelunk
                                }
                            }
                            if (tmp == null){
                                // ha nem talaltunk ismetlodest, tehat ez a tmp meg mindig null
                                molekulak.get(molekulak.size() - 1).elemek.add(new Elemek(elemek.get(j).elem, elemek.get(j).vegyjel));
                                // adjunk a molekulahoz egy uj atomot az elemek lista segitsegevel
                            } else {
                                // ha talaltunk ismetlodest
                                tmp.setHanyszor();
                                // a setHanyszor annyit csinal megnoveli az atom elofordulasat egyszer
                                // a tmp altal pedig pont azt a molekulan beluli atomot fogjuk elerni ahol talaltuk az ismetlodest
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(molekulak);
        // sortoljuk a kulso osztalyt elobb, tehat a molekulak neveit
        for (Molekulak m:molekulak
             ) {
            Collections.sort(m.elemek);
        }
        // majd minden molekulan belul sortoljuk az atomokat
        for (Molekulak m:molekulak
             ) {
            System.out.println(m);
        }
        // vegul minden molekulat kiiratunk az o atomjaival
    }
}
