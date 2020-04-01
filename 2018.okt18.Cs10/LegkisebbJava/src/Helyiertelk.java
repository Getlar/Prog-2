import java.util.Scanner;

public class Helyiertelk {
    public static void main(String[] args) {
        int[] szamok = new int[10];
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String akt = sc.nextLine();
            for (int i = 0; i < akt.length() ; i++) {
                if (i < akt.length() - 1 && Character.isDigit(akt.charAt(i)) && (Character.isWhitespace(akt.charAt(i + 1)))) {
                    int a = Character.getNumericValue(akt.charAt(i));
                    szamok[a]++;
                }
            }
            if (Character.isDigit(akt.charAt(akt.length() - 1))) {
                int a = Character.getNumericValue(akt.charAt(akt.length()-1));
                szamok[a]++;
            }
        }
        for (int i = 0; i < szamok.length; i++){
            System.out.println(i + ": " + szamok[i] + " db");
        }
    }
}
