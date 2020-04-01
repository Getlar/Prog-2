import java.util.Arrays;
import java.util.Scanner;

class Emberek implements Comparable<Emberek>{
    private String nev;
    private int hanyan;

    public Emberek(String nev, int hanyan) {
        this.nev = nev;
        this.hanyan = hanyan;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getHanyan() {
        return hanyan;
    }

    public void setHanyan(int hanyan) {
        this.hanyan = hanyan;
    }

    @Override
    public int compareTo(Emberek o) {
        if(this.hanyan > o.hanyan){
            return -1;
        }
        if(this.hanyan < o.hanyan) {
            return 1;
        }
        if(this.nev.compareTo(o.nev) > 0){
            return 1;
        }
        if(this.nev.compareTo(o.nev) < 0){
            return -1;
        }
        return 0;
    }
}
public class Valosagshow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] elso = sc.nextLine().split(" ");
        int n = Integer.parseInt(elso[0]);
        int k = Integer.parseInt(elso[1]);
        Emberek[] emberek = new Emberek[n];
        for (int i = 0; i < emberek.length; i++){
            String egy = ":";
            String ketto = ",";
            String be = sc.nextLine().replaceAll(egy, ketto);
            String[] nevek = be.split(ketto);
            int l = nevek.length - 1;
            emberek[i] = new Emberek(nevek[0], l);
        }
        Arrays.sort(emberek);
        for(int i = 0; i < emberek.length; i++){
            if (emberek[i].getHanyan() >= k){
                System.out.println(emberek[i].getNev());
            }
        }
    }
}
