import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;
public class Mozisztartok {

    static class Film implements Comparable<Film>{
        int ev;
        String nev;

        public Film(int ev, String nev) {
            this.ev = ev;
            this.nev = nev;
        }

        @Override
        public String toString() {
            return ev + ": " + nev;
        }

        @Override
        public int compareTo(Film o) {
            if (this.ev > o.ev){
                return 1;
            }
            if (this.ev < o.ev){
                return -1;
            }
            if (this.nev.compareTo(o.nev) > 0){
                return 1;
            }
            if (this.nev.compareTo(o.nev) < 0){
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args){
        Map<String, Set<Film>> map = new TreeMap<String, Set<Film>>();
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(":");
            String[] token1 = be[1].split(",");
            int seged = 0;
            for (int i = 0; i < be[0].length(); i++){
                if (be[0].charAt(i) == ' '){
                    seged = i;
                }
            }
            String subs = be[0].substring(seged+2, be[0].length()-1);
            String subs2 = be[0].substring(0,be[0].length()-7);
            for (String s: token1
                 ) {
                Set<Film> tmp = map.get(s);
                if (tmp == null){
                    tmp = new TreeSet<>();
                    map.put(s,tmp);
                }
                tmp.add(new Film(Integer.parseInt(subs), subs2));
            }
            
        }
        List<Map.Entry<String, Set<Film>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> {
            if (a.getValue().size() > b.getValue().size()) {
                return -1;
            }
            if (a.getValue().size() < b.getValue().size()) {
                return 1;
            }
            return 0;
        });
        Map<String, Set<Film>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Set<Film>> entry: entries
             ) {
            sortedMap.put(entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String, Set<Film>> entry :sortedMap.entrySet()
             ) {
            StringJoiner sj  = new StringJoiner("\n");
            for (Film f: entry.getValue()
                 ) {
                sj.add(f.toString());
            }
            System.out.println(entry.getKey() + "\n" + sj.toString());
        }
    }
}
