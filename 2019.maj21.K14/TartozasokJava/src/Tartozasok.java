import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Tartozasok {
    public static void main(String[] args){
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] be  = line.split(";");
            for (int i = 2; i < be.length; i++){
                Map<String, Integer> entry = map.get(be[i]);
                if (entry == null){
                    entry = new TreeMap<>();
                    map.put(be[i],entry);
                }
                int sum = 0;
                if (!entry.containsKey(be[0])) {
                    entry.put(be[0], sum);
                }
                entry.put(be[0], entry.get(be[0]) + Integer.parseInt(be[1]));
            }
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()
             ) {
            for (Map.Entry<String, Integer> foo : entry.getValue().entrySet()
                 ) {
                System.out.println(entry.getKey() + " => " + foo.getKey() + ": " + foo.getValue());
            }
        }
    }
}
