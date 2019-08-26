package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            HashSet<Character> sets1 = new HashSet<>();
            for (int i = 0; i < s1.length(); i++) {
                sets1.add(s1.charAt(i));
            }
            for (int i = 0; i < s2.length(); i++) {
                if (sets1.contains(s2.charAt(i))) {
                    System.out.println("Yes");
                    continue outer;
                }
            }
            System.out.println("No");
        }
    }
}
