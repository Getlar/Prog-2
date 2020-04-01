// Forrás: https://progcont.hu/progcont/100283/?pid=201307

/*
A lenti két import a szöveges állománykezeléshez kellett nekem.
Ezt még túl korai megtanulni, de ha nem jelölünk ki egy kiugrási értéket (pl. 0-t),
akkor az EOF-os beolvasást így lehet kipróbálni - fájlhasználattal.
A kivételkezelési rész is a fájlhasználat miatt kell.

Fájlos tesztelésnél az alapértelmezés a projektkönyvtár.
Avagy egy szinten az 'src' könyvtárral.
A hivatkozás az elérési útra lehet abszolút vagy relatív.
*/
//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class Forgalom {
    public static void main(String[] args) /*throws FileNotFoundException*/ {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("stat.txt"));
        /*
        Három változó: törzsutasszám, a menet közben felszállók mint "tartalék"
        és a megállónkénti változás előjeles mértéke.
        */
        int torzs, tartalek, valtozas;
        torzs = sc.nextInt();
        tartalek = 0;
        /*
        Mivel elsőre nekem sem ment, ezért jó tanuló módjára önellenőrzést csináltam.
        Kiírtam a konzolra, hogy kezdetben és minden kör után
        milyen értékek vannak a megadott változókban.
        */
//        System.out.println("Utasszám: " + torzs + " + " + tartalek + " = "
//                    + (torzs + tartalek));
        while(sc.hasNextInt()){
            valtozas = sc.nextInt();
            /*
            Ez lenne a kiugrási feltétel jelképesen. Itt azonban veszélyes,
            mivel lehet olyan megálló, ahol nincs utasváltozás.
            */
//            if(valtozas == 0)
//                break;
            // Felszállás esetén
            if(valtozas >= 0){
                tartalek += valtozas;
                // Leszállás esetén
            } else {
                // A kivonások miatt kell az ellentett érték.
                valtozas *= -1;
                /*
                Ha a teljes mérték levonható a tartalékból, akkor onnan vesszük le.
                */
                if(valtozas <= tartalek){
                    tartalek -= valtozas;
                /*
                Ha a változás tűlnő a tartalékon, akkor a tartalékot kinullázzuk,
                és csak a kettő különbsége jön le a törzsutasszámból.
                */
                } else {
                    valtozas -= tartalek;
                    tartalek = 0;
                    torzs -= valtozas;
                }
            }
//            System.out.println("Utasszám: " + torzs + " + " + tartalek + " = "
//                    + (torzs + tartalek));
        }
//        sc.close();
        System.out.println(torzs);
    }
}
