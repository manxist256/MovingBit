package CodeChef.Practice;

import java.util.Scanner;

public class BuggyCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String string[] = scanner.nextLine().split(" ");
            String a = string[0], b = string[1];
            if (a.length() > b.length()) {
                int diff = a.length() - b.length();
                for (int i = 0; i < diff; i++) {
                    b = '0' + b;
                }
            } else if (a.length() < b.length()) {
                int diff = b.length() - a.length();
                for (int i = 0; i < diff; i++) {
                    a = '0' + a;
                }
            }
            String ans = "";
            for (int i = a.length() - 1; i >= 0; i--) {
                int an = a.charAt(i) - 48, bn = b.charAt(i) - 48;
                ans = ((an + bn) % 10) + ans;
            }
            System.out.println(Long.parseLong(ans));
        }
    }
}
