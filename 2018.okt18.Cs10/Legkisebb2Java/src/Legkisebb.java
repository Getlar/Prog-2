import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Legkisebb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int legkisebb = 0;
        int valtozo = 0;
        while (sc.hasNextLine()){
            ArrayList<Integer> szamok = new ArrayList<Integer>();
            String be = sc.nextLine();
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher m = p.matcher(be);
            while (m.find()){
                int value = Integer.parseInt(m.group());
                szamok.add(value);
                valtozo++;
            }
            Collections.sort(szamok);
            if(szamok.isEmpty()){
                System.out.println("unknown");
            }else {
                System.out.println(szamok.get(0));
                valtozo = 0;
            }
        }
    }
}
