import java.util.Arrays;
import java.util.Scanner;
class Emberek implements Comparable<Emberek>{

    String nev;
    String neptunKod;
    String nap;

    public Emberek(String nev, String neptunKod, String nap) {
        this.nev = nev;
        this.neptunKod = neptunKod;
        this.nap = nap;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public String getNap() {
        return nap;
    }

    public void setNap(String nap) {
        this.nap = nap;
    }

    @Override
    public int compareTo(Emberek o) {
        if (this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if (this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        if (this.neptunKod.compareTo(o.neptunKod) > 0){
            return 1;
        }
        if (this.neptunKod.compareTo(o.neptunKod) < 0){
            return -1;
        }
        return 0;
    }
}


public class Cserebere {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        String[] be = sc.nextLine().split(" ");
        int n = Integer.parseInt(be[0]);
        String nap = be[1];
        Emberek[] emberek = new Emberek[n];
        for (int i = 0; i < emberek.length; i++){
            String[] be2 = sc.nextLine().split(":");
            emberek[i] = new Emberek(be2[0], be2[1], be2[2]);
        }
        while (sc.hasNextLine()){
            String egy = "-";
            String ketto = ">";
            String nagy = sc.nextLine().replaceAll(egy, ketto);
            String[] be3 = nagy.split(ketto);
            for (int i = 0; i < emberek.length; i++){
                if(be3[0].equals(emberek[i].getNeptunKod())){
                    emberek[i].setNap(be3[2]);
                }
            }
        }
        Arrays.sort(emberek);
        for (int i = 0; i < emberek.length; i++){
            if (emberek[i].getNap().equals(nap)){
                System.out.println(emberek[i].getNev() + " (" + emberek[i].getNeptunKod() + ")");
            }
        }
    }
}
