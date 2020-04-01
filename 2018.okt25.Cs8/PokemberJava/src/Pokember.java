import java.util.Scanner;

public class Pokember {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] be = sc.nextLine().split(" ");
        int liftezes = 0;
        if (be.length == 1){
            System.out.println(0);
        }
        else{
            for (int i = 1; i < be.length; i = i + 2){
                if (Integer.parseInt(be[i-1]) + Integer.parseInt(be[i+1]) >= Integer.parseInt(be[i])){
                    liftezes = liftezes + Integer.parseInt(be[i-1]) + Integer.parseInt(be[i+1]);
                }
            }
            System.out.println(liftezes);
        }
    }
}
