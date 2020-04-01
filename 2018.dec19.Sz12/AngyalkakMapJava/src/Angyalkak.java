import java.util.*;

public class Angyalkak {
    private static class Nevek implements Comparable<Nevek>{
        String nev;

        public Nevek(String nev) {
            this.nev = nev;
        }

        @Override
        public String toString() {
            return nev;
        }

        @Override
        public int compareTo(Nevek o) {
            return this.nev.compareTo(o.nev);
        }
    }

    public static void main(String[] args){
        Map<Integer, Set<Nevek>> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(":");
            String[] evek = be[1].split(",");
            for (String s: evek
                 ) {
                Set<Nevek> ertek = map.get(Integer.parseInt(s));
                if (ertek == null){
                    ertek = new TreeSet<>();
                    map.put(Integer.parseInt(s), ertek);
                }
                ertek.add(new Nevek(be[0]));
            }
        }
        for (Map.Entry<Integer, Set<Nevek>> entry:map.entrySet()
             ) {
            StringJoiner sj = new StringJoiner(",");
            for (Nevek n:entry.getValue()
                 ) {
                sj.add(n.toString());
            }
            System.out.println(entry.getKey() + ":" + sj.toString());
        }
    }
}
