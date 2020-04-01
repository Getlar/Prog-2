import java.util.Arrays;
import java.util.Scanner;

public class Tomb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String elso[];
        String masodik[];
        int szamok[];
        int i;
        elso = sc.nextLine().split(" ");
        masodik = sc.nextLine().split(" ");
        szamok = new int[elso.length + masodik.length];
        for (i = 0; i < szamok.length; i++){
            if(i >= elso.length){
                szamok[i] = Integer.parseInt(masodik[i-elso.length]);
            }
            else{
                szamok[i] = Integer.parseInt(elso[i]);
            }
        }
        Arrays.sort(szamok);
        for(i = 0 ; i < szamok.length ; i++){
            if(i != szamok.length-1){
                System.out.print(szamok[i]+ " ");
            }
            else{
                System.out.println(szamok[i]);
            }
        }


    }
}
