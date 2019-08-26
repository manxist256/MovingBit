package CodeChef.Practice;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Sticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < N; i++) {
                int stickLength = scanner.nextInt();
                if (!map.containsKey(stickLength)) {
                    map.put(stickLength, 0);
                }
                int ev = map.get(stickLength);
                map.put(stickLength, ++ev);
            }
            int sticksReq = 4; long area = 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int stickLength = entry.getKey(), stickC = entry.getValue();
                if (sticksReq >= 2 && stickC >= 2) {
                    if (sticksReq > 2 && stickC >= 4) {
                        System.out.println(stickLength * stickLength);
                        continue outer;
                    }
                    area *= stickLength;
                    sticksReq -= 2;
                    if (sticksReq == 0) {
                        System.out.println(area);
                        continue outer;
                    }
                }
            }
            System.out.println(-1);
        }
    }
}
