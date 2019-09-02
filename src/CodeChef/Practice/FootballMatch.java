package CodeChef.Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class FootballMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String team = scanner.nextLine();
                if (!map.containsKey(team)) {
                    map.put(team, 0);
                }
                int eg = map.get(team);
                map.put(team, ++eg);
            }
            int max = -1; String ans = "Draw";
            HashSet<Integer> set = new HashSet<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    ans = entry.getKey();
                    max = entry.getValue();
                }
                set.add(entry.getValue());
            }
            System.out.println(set.size() == 1 && map.size() == 2 ? "Draw" : ans);
        }
    }
}
