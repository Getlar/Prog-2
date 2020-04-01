import java.util.*;

public class Turastatisztika {
    private static class Ember implements Comparable<Ember>{
        String nev;
        int mennyitment;

        public Ember(String nev, int mennyitment) {
            this.nev = nev;
            this.mennyitment = mennyitment;
        }

        @Override
        public int compareTo(Ember o) {
            if (this.mennyitment > o.mennyitment){
                return -1;
            }
            if (this.mennyitment < o.mennyitment){
                return 1;
            }
            if (this.nev.compareTo(o.nev) > 0){
                return 1;
            }
            if (this.nev.compareTo(o.nev) < 0){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return nev;
        }
    }
    public static void main (String[] args){
        Map<String, Set<Ember>> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(";");
            for (int i=1; i<be.length; i++){
                String[] utak = be[i].split(":");
                Set<Ember> ertek = map.get(utak[0]);
                if (ertek == null){
                    ertek = new TreeSet<>();
                    map.put(utak[0],ertek);
                }
                ertek.add(new Ember(be[0], Integer.parseInt(utak[1])));
            }
        }
        for (Map.Entry<String, Set<Ember>> entry: map.entrySet()
             ) {
            StringJoiner sj = new StringJoiner(", ");
            for (Ember e : entry.getValue()
                 ) {
                sj.add(e.toString());
            }
            System.out.println(entry.getKey() + " (" + entry.getValue().size() + "):" + sj.toString());
        }
    }
}
