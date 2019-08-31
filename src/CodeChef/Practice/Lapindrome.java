package CodeChef.Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lapindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            String s = scanner.nextLine();
            int mid = s.length() / 2;
            HashMap<Character, Integer> fpc = new HashMap<>();
            HashMap<Character, Integer> spc = new HashMap<>();
            for (int i = 0; i < mid; i++) {
                char c = s.charAt(i);
                if (!fpc.containsKey(c)) {
                    fpc.put(c, 0);
                }
                int g = fpc.get(c);
                fpc.put(c, ++g);
            }
            mid = s.length() % 2 == 0 ? mid : mid + 1;
            for (int j = mid; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!spc.containsKey(c)) {
                    spc.put(c, 0);
                }
                int g = spc.get(c);
                spc.put(c, ++g);
            }
            for (Map.Entry<Character, Integer> entry : fpc.entrySet()) {
                if (!spc.containsKey(entry.getKey()) || (int)spc.get(entry.getKey()) != entry.getValue()) {
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}
