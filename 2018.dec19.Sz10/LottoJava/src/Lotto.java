import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] szamok = new int[86];
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(" ");
            for (int i = 1; i < be.length; i++){
                szamok[Integer.parseInt(be[i]) - 5]++;
            }
        }

        int maxhanyszor = 0;
        List<Integer> legtobbszorszamok = new ArrayList<>();

        for (int i = 0; i < szamok.length; i++){
            if (szamok[i] > maxhanyszor){
                maxhanyszor = szamok[i];
                legtobbszorszamok = new ArrayList<>();
                legtobbszorszamok.add(i + 5);
            }
            else if (szamok[i] == maxhanyszor){
                legtobbszorszamok.add(i + 5);
            }
        }
        Collections.sort(legtobbszorszamok);
        for (int i = 0; i < legtobbszorszamok.size(); i++){
            if (i == legtobbszorszamok.size() - 1){
                System.out.print(legtobbszorszamok.get(i) + "\n");
            }else{
                System.out.print(legtobbszorszamok.get(i) + " ");
            }
        }
    }
}
