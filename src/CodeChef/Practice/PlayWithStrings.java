package CodeChef.Practice;

import java.util.Scanner;

public class PlayWithStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            String r = scanner.nextLine();
            int z1 = 0, o1 = 0, z2 = 0, o2 = 0;
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '0') {
                    z1++;
                } else {
                    o1++;
                }
                if (r.charAt(i) == '0') {
                    z2++;
                } else {
                    o2++;
                }
            }
            if (z1 == z2 && o1 == o2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
