package CodeChef.Practice;

import java.util.Scanner;

public class XorAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            long xor = 0;
            for (int i = 0; i < N; i++) {
                long v = scanner.nextLong() * 2;
                xor = xor ^ v;
            }
            System.out.println(xor);
        }
    }
}
