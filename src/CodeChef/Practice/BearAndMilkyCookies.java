package CodeChef.Practice;

import java.util.Scanner;

public class BearAndMilkyCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] p = scanner.nextLine().split(" ");
            for (int i = 0; i < N - 1; i++) {
                if (p[i].equals("cookie") && !p[i + 1].equals("milk")) {
                    System.out.println("NO");
                    continue outer;
                }
            }
            if (p[p.length - 1].equals("cookie")) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }
}
