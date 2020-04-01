import java.util.Scanner;

public class Lotto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be;
        int[] szamok = new int[35];
        while (sc.hasNextLine()){
            be = sc.nextLine().split(" ");
            for (int i = 1; i < be.length; i++){
                szamok[Integer.parseInt(be[i])-1]++;
            }
        }
        for (int i = 0; i < szamok.length; i++){
            System.out.println(i+1 + ": " + szamok[i]);
        }
    }
}
