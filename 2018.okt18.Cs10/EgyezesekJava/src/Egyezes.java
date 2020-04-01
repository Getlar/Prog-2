import java.util.Scanner;

public class Egyezes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int szamlalo = 0;
        String vege = "END";
        while (sc.hasNextLine()){
            String be2 = sc.nextLine();
            if(be2.equals(vege)){
                break;
            }
            String[] be = be2.split(" ");
            if (be[0].length() <= be[1].length()){
                for (int i = 0 ; i < be[0].length(); i++){
                    if (be[0].charAt(i) == be[1].charAt(i)){
                        szamlalo++;
                    }
                }
            }
            if (be[0].length() > be[1].length()){
                for (int i = 0 ; i < be[1].length(); i++){
                    if (be[0].charAt(i) == be[1].charAt(i)){
                        szamlalo++;
                    }
                }
            }
            System.out.println(be[0] + "-" + be[1] + ": " + szamlalo);
            szamlalo = 0;
        }
    }
}
