import java.util.*;

public class Karacsony {
    public static void main(String[] args){
        Map<String, Integer> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(";");
            if (!map.containsKey(be[0])){
                map.put(be[0], 0);
            }
            map.put(be[0],map.get(be[0]) + Integer.parseInt(be[1]));
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a,b) -> {
            if (a.getValue() > b.getValue()){
                return -1;
            }
            if (a.getValue() < b.getValue()){
                return 1;
            }
            if (a.getKey().compareTo(b.getKey()) > 0){
                return 1;
            }
            if (a.getKey().compareTo(b.getKey()) < 0){
                return -1;
            }
            return 0;
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry: entries
             ) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry: sortedMap.entrySet()
             ) {
            System.out.println(entry.getKey() + ";" + entry.getValue());
        }

    }
}
