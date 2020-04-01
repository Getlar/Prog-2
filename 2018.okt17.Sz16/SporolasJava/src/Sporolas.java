import java.util.Scanner;

public class Sporolas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sor = sc.nextLine().split(" ");
        int max = Integer.parseInt(sor[0]);
        int tank = Integer.parseInt(sor[1]);
        int kutak = Integer.parseInt(sor[2]);
        int fogyasztas = Integer.parseInt(sor[3]);

        int elozo, akt;
        int tankolas;
        int tav;
        int i = 0;

        if(tank / fogyasztas < max){
            elozo = 0;
            for (i = 0; i < kutak; i++) {
                sor = sc.nextLine().split(" ");
                akt = Integer.parseInt(sor[0]);
                tankolas = Integer.parseInt(sor[1]);
                tav = akt - elozo;
                max -= tav;
                tank = tank - (tav * fogyasztas);
                if(tank / fogyasztas >= max){
                    break;
                }
                tank += tankolas;
                elozo = akt;
            }
            System.out.println(i);
        }
        else{
            System.out.println(i);
        }
    }
}
