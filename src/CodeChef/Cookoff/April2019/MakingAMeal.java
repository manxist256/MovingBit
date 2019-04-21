package CodeChef.Cookoff.April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MakingAMeal {
    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String s = bufferedReader.readLine();
                for (int j = 0; j < s.length(); j++) {
                    if (!(s.charAt(j) == 'c' || s.charAt(j) == 'o' || s.charAt(j) == 'd' || s.charAt(j) == 'e'||s.charAt(j) == 'h'|| s.charAt(j) == 'f')) {
                        continue;
                    }
                    if (!map.containsKey(s.charAt(j))) {
                        map.put(s.charAt(j), 0);
                    }
                    int gex = map.get(s.charAt(j));
                    map.put(s.charAt(j), ++gex);
                    //System.out.println(map);
                }
            }
            try {
                if (map.size() != 6) {
                    System.out.println(0);
                    continue;
                }
                int gcc = map.get('c');
                map.put('c', gcc / 2);
                int gec = map.get('e');
                map.put('e', gec / 2);
                int min = Integer.MAX_VALUE;
                //System.out.println(map);
                for (Map.Entry etr : map.entrySet()) {
                    if ((int)etr.getValue() < min) {
                        min = (int)etr.getValue();
                    }
                }
                System.out.println(min);

            } catch(Exception e) {
                System.out.println(0);
            }
        }
    }
}
