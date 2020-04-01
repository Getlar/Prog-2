
import java.util.Arrays;
import java.util.Scanner;

class Jelszo implements Comparable<Jelszo>{

    String jsz;
    int szamjegyek;

    public Jelszo(String jsz) {
        this.jsz = jsz;
        this.szamjegyek = 0;
        for (int i = 0; i < jsz.length(); i++) {
            if(Character.isDigit(jsz.charAt(i))){
                this.szamjegyek++;
            }
        }
    }

    @Override
    public String toString() {
        return jsz;
    }

    @Override
    public int compareTo(Jelszo j) {
        if(this.jsz.length() > j.jsz.length())
            return -1;
        if(this.jsz.length() < j.jsz.length())
            return 1;
        if(this.szamjegyek > j.szamjegyek)
            return -1;
        if(this.szamjegyek < j.szamjegyek)
            return 1;
        return this.jsz.compareTo(j.jsz);
    }
}

public class JelszoErosseg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Jelszo[] jelszavak = new Jelszo[n];

        for (int i = 0; i < jelszavak.length; i++) {
            jelszavak[i] = new Jelszo(sc.nextLine());
        }

        Arrays.sort(jelszavak);

        for (int i = 0; i < jelszavak.length; i++) {
            System.out.println(jelszavak[i].toString());
        }
    }
}
