package CodeChef.Practice;

import java.util.Scanner;

public class BearAndSegment01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            char prev = s.charAt(0);
            int oc = 0;
            if (prev == '1') {
                oc++;
            }
            for (int i = 1; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (curr != prev) {
                    if (curr == '1') {
                        oc++;
                    }
                }
                prev = curr;
            }

            System.out.println(oc == 1 ? "YES" : "NO");
        }
    }
}
