import java.util.Arrays;
import java.util.Scanner;

class Orak implements Comparable<Orak>{

    private String targykod;
    private String targynev;
    private int kreditszam;
    private int ajanlottFelev;
    private int specialis;

    public Orak(String targykod, String targynev, int kreditszam) {
        this.targykod = targykod;
        this.targynev = targynev;
        this.kreditszam = kreditszam;
        String[] itt = targykod.split("-");
        this.ajanlottFelev = Integer.parseInt(itt[1]);
        this.specialis = Integer.parseInt(itt[2]);
    }

    public String getTargykod() {
        return targykod;
    }

    public void setTargykod(String targykod) {
        this.targykod = targykod;
    }

    public String getTargynev() {
        return targynev;
    }

    public void setTargynev(String targynev) {
        this.targynev = targynev;
    }

    public int getKreditszam() {
        return kreditszam;
    }

    public void setKreditszam(int kreditszam) {
        this.kreditszam = kreditszam;
    }

    public int getAjanlottFelev() {
        return ajanlottFelev;
    }

    public void setAjanlottFelev(int ajanlottFelev) {
        this.ajanlottFelev = ajanlottFelev;
    }

    public int getSpecialis() {
        return specialis;
    }

    public void setSpecialis(int specialis) {
        this.specialis = specialis;
    }

    @Override
    public int compareTo(Orak o) {
        if (this.ajanlottFelev > o.ajanlottFelev){
            return 1;
        }
        if (this.ajanlottFelev < o.ajanlottFelev){
            return -1;
        }
        if (this.specialis > o.specialis){
            return 1;
        }
        if (this.specialis < o.specialis){
            return -1;
        }
        return 0;
    }
}


public class Orarend {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Orak[] orak = new Orak[n];
        for(int i = 0; i < orak.length ; i++){
            String[] be = sc.nextLine().split(":");
            orak[i] = new Orak(be[0], be[1], Integer.parseInt(be[2]));
        }
        Arrays.sort(orak);
        for(int i = 0; i < orak.length; i++){
            System.out.println(orak[i].getTargynev());
        }
    }
}
