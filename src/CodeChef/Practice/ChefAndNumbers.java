package CodeChef.Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChefAndNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int v = scanner.nextInt();
                if (!map.containsKey(v)) {
                    map.put(v, 0);
                }
                int ev = map.get(v);
                map.put(v, ++ev);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println("Yes");
                    continue outer;
                }
            }
            System.out.println("No");
        }
    }
}
