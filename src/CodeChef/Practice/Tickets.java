package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class Tickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            String s = scanner.nextLine();
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    System.out.println("NO");
                    continue outer;
                }
                set.add(s.charAt(i));
            }
            System.out.println(set.size() == 2 ? "YES" : "NO");
        }
    }
}
