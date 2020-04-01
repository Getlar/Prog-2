import java.util.Scanner;

public class Venek {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hanyeves = 2015;
        String nev = "";
        String[] sor;
        while (sc.nextLine().compareTo("0")!= 0){
            sor = sc.nextLine().split(" ");
            if(Integer.parseInt(sor[0]) < hanyeves){
                hanyeves = Integer.parseInt(sor[0]);
                nev = sor[1];
            }
        }
        System.out.println(nev + "(" + hanyeves + ")");
    }
}
