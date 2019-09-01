package CodeChef.Practice;

import java.util.Scanner;

public class AdaAndCrayons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            char prev = s.charAt(0);
            int uc = 0, dc = 0;
            for (int i = 1; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (i == s.length() - 1) {
                    if (curr == 'U') {
                        uc++;
                    } else {
                        dc++;
                    }
                }
                if (curr != prev) {
                    if (prev == 'U') {
                        uc++;
                    } else {
                        dc++;
                    }
                }
                prev = curr;
            }
            System.out.println(Math.min(uc, dc));
        }
    }
}
