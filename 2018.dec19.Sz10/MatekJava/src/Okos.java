import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Okos {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        double x = 0;
        int hanyadik = 0;
        int allito = 0;
        while (sc.hasNextLine()) {
            String be = sc.nextLine();
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher m = p.matcher(be);
            while (m.find()){
                if (hanyadik == 0){
                    a = Integer.parseInt(m.group());
                }
                if (hanyadik == 1){
                    b = Integer.parseInt(m.group());
                }
                hanyadik++;
            }
            for (int i = 0; i < be.length(); i++) {
                if (be.charAt(i) == '+'){
                    allito = 0;
                }
                if (be.charAt(i) == '-'){
                    allito = 1;
                }
            }
            if (allito == 0) {
                x = (double) -b / a;
                if (x % 1 != 0) {
                    System.out.println("No solution.");
                } else {
                    System.out.println((int) x);
                }
            }
            if (allito == 1){
                x = (double) b / a;
                if (x % 1 != 0) {
                    System.out.println("No solution.");
                } else {
                    System.out.println((int) x);
                }
            }
            hanyadik = 0;
        }
    }
}
