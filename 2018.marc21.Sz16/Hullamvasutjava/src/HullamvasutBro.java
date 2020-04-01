import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HullamvasutBro {

    static class Vasut implements Comparable<Vasut>{
        String name;
        String world;
        int height;
        int wait;

        public Vasut(String name, String world, int height, int wait) {
            this.name = name;
            this.world = world;
            this.height = height;
            this.wait = wait;
        }

        @Override
        public String toString() {
            return name + " (" + world + "): " + wait;
        }

        @Override
        public int compareTo(Vasut o) {
            if (this.wait > o.wait){
                return 1;
            }
            if (this.wait < o.wait){
                return -1;
            }
            if (this.height > o.height){
                return -1;
            }
            if (this.height < o.height){
                return 1;
            }
            if (this.name.compareTo(o.name) > 0)
            {
                return 1;
            }
            if (this.name.compareTo(o.name) < 0)
            {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Vasut[] vasutak = new Vasut[n];
        for (int i = 0; i < vasutak.length; i++){
            String[] be = sc.nextLine().split(";");
            vasutak[i] = new Vasut(be[0], be[1], Integer.parseInt(be[2]), Integer.parseInt(be[3]));
        }
        Arrays.sort(vasutak);
        for (Vasut v: vasutak
             ) {
            System.out.println(v);
        }
    }
}
