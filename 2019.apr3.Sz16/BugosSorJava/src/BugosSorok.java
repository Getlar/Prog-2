import java.util.Scanner;

public class BugosSorok {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sor;
        while(sc.hasNextLine()){
            sor = sc.nextLine().toLowerCase();
            if(sor.contains("bug")){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }
    }
}
