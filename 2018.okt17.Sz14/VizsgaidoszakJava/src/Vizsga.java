import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Vizsga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] napok1 = sc.nextLine().split(" ");
        String[] napok2 = sc.nextLine().split(" ");
        ArrayList<String> a1 = new ArrayList<String>(Arrays.asList(napok1));
        ArrayList<String> a2 = new ArrayList<String>(Arrays.asList(napok2));
        int szamlalo = 0;
        for (String s : a1){
            for(String l : a2){
                if(s.equals(l)){
                    szamlalo++;
                }
            }
        }
        System.out.println(szamlalo);
    }
}
