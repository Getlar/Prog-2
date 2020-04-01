import java.util.Scanner;

public class Szovegszerkeszto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String be = sc.nextLine();
        int pozicio;
        int hossz;
        System.out.println(be);
        while (sc.hasNextLine()){
            String[] parancs = sc.nextLine().split(" ");
            switch (parancs[0]){
                case "insert":
                    pozicio = Integer.parseInt(parancs[1]);
                    if ((pozicio <= -1) || (pozicio > be.length())){
                        break;
                    }
                    if (be.length() + parancs[2].length() > 80){
                        break;
                    }
                    be = be.substring(0, pozicio) + parancs[2] + be.substring(pozicio);
                    System.out.println(be);
                    break;
                case "delete":
                    pozicio = Integer.parseInt(parancs[1]);
                    hossz = Integer.parseInt(parancs[2]);
                    if ((pozicio <= -1) || (pozicio > be.length())){
                        break;
                    }
                    if ((hossz <= 0) || ((pozicio + hossz) > be.length())){
                        break;
                }
                    be = be.substring(0, pozicio) + be.substring(pozicio + hossz);
                    System.out.println(be);
                    break;
            }
        }
    }
}
