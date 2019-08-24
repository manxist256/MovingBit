package CodeChef.Practice;

import java.util.Scanner;

public class CoinsInATriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long n2 = scanner.nextInt() * 2;
            for (int i = 0; i < 100005; i++) {
                long p1 = (long)Math.pow(i, 2) + i;
                long p2 = (long)Math.pow(i + 1, 2) + i;
                if (p1 <= n2 && p2 > n2) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
