import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Meeting {
    public static void main(String[] args){
        Map<String, Integer> map = new TreeMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] be = sc.nextLine().split(";");
            String[] orak = be[1].split(":");
            int ora = Integer.parseInt(orak[0]) * 60;
            int perc = Integer.parseInt(orak[1]);
            int ossz = ora + perc;
            if (map.containsKey(be[0])){
                map.put(be[0], map.get(be[0]) + ossz);
            }
            else {
                map.put(be[0], ossz);
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
        }
    }
}
