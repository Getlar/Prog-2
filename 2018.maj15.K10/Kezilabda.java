// Forrás: https://progcont.hu/progcont/100268/?pid=201263

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Jatekos {

    String nev;
    int golszam;

    public Jatekos(String nev) {
        this.nev = nev;
        this.golszam = 0;
    }
}

class Csapat {

    String csapatnev;
    List<Jatekos> csapattagok;
    int maxGolszam;

    public Csapat(String csapatnev) {
        this.csapatnev = csapatnev;
        this.csapattagok = new ArrayList<>();
        this.maxGolszam = 0;
    }
}

class Golkiraly implements Comparable<Golkiraly> {

    String nev, csapatnev;

    public Golkiraly(String nev, String csapatnev) {
        this.nev = nev;
        this.csapatnev = csapatnev;
    }

    @Override
    public String toString() {
        return nev + " (" + csapatnev + ")";
    }

    @Override
    public int compareTo(Golkiraly gk) {
        if (!this.nev.equals(gk.nev)) {
            return this.nev.compareTo(gk.nev);
        }
        return this.csapatnev.compareTo(gk.csapatnev);
    }
}

public class Kezilabda {

    public static void main(String[] args) {
        Scanner sc = null;
        String[] sor;
        List<Csapat> csapatok = new ArrayList<>();
        List<Golkiraly> golkiralyok = new ArrayList<>();
        Csapat csTmp1, csTmp2;
        Jatekos jTmp;
        int max = 0;
        // Végigzongorázás a fájlokon
        for (int i = 0; i < args.length; i++) {
            try {
                sc = new Scanner(new File(args[i]));
                // Csapatnevek kinyerése
                sor = sc.nextLine().split(" - ");
                /*
                Csapatok megkeresése
                Ha nem szerepel, akkor felvezetjük újként.
                Ha szerepel, akkor azzal fogunk dolgozni a továbbiakban.
                 */
                // Első csapat
                csTmp1 = null;
                for (Csapat cs : csapatok) {
                    if (cs.csapatnev.equals(sor[0])) {
                        csTmp1 = cs;
                        break;
                    }
                }
                if (csTmp1 == null) {
                    csTmp1 = new Csapat(sor[0]);
                    csapatok.add(csTmp1);
                }
                // Második csapat
                csTmp2 = null;
                for (Csapat cs : csapatok) {
                    if (cs.csapatnev.equals(sor[1])) {
                        csTmp2 = cs;
                        break;
                    }
                }
                if (csTmp2 == null) {
                    csTmp2 = new Csapat(sor[1]);
                    csapatok.add(csTmp2);
                }
                // Játékosok adminisztrálása
                // Első csapat
                for (int k = 0; k < 7; k++) {
                    sor = sc.nextLine().split(":");
                    jTmp = null;
                    for (Jatekos j : csTmp1.csapattagok) {
                        if (j.nev.equals(sor[0])) {
                            jTmp = j;
                            break;
                        }
                    }
                    if (jTmp == null) {
                        jTmp = new Jatekos(sor[0]);
                        csTmp1.csapattagok.add(jTmp);
                    }
                    jTmp.golszam += Integer.parseInt(sor[1]);
                }
                // Második csapat
                for (int k = 0; k < 7; k++) {
                    sor = sc.nextLine().split(":");
                    jTmp = null;
                    for (Jatekos j : csTmp2.csapattagok) {
                        if (j.nev.equals(sor[0])) {
                            jTmp = j;
                            break;
                        }
                    }
                    if (jTmp == null) {
                        jTmp = new Jatekos(sor[0]);
                        csTmp2.csapattagok.add(jTmp);
                    }
                    jTmp.golszam += Integer.parseInt(sor[1]);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Kezilabda.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (sc != null) {
                    sc.close();
                }
            }
        }
        /*
        Minden, ami már nem a feltöltéssel kapcsolatos, 
        a beolvasási blokkon kívül helyezkedik el.
        */
        // Maximum gólszám meghatározása
        for (Csapat cs : csapatok) {
            for (Jatekos j : cs.csapattagok) {
                if (j.golszam > max) {
                    max = j.golszam;
                }
            }
        }
        System.out.println(max);
        // Gólkirályok kigyűjtése
        /*
        Mivel a megadott szempontok alapján a kilistázás nem lehetséges 
        a meglévő osztályokkal, ezért új osztályt kell bevezetni.
         */
        for (Csapat cs : csapatok) {
            for (Jatekos j : cs.csapattagok) {
                if (j.golszam == max) {
                    golkiralyok.add(new Golkiraly(j.nev, cs.csapatnev));
                }
            }
        }
        Collections.sort(golkiralyok);
        for (Golkiraly gk : golkiralyok) {
            System.out.println(gk);
        }
    }
}
