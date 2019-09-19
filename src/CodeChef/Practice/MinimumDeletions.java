package CodeChef.Practice;

import java.util.Scanner;

public class MinimumDeletions {

    static int getGCD(int a, int b) {
        if (b == 0) return a;
        else return getGCD(b,a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int GCD = scanner.nextInt();
            for (int i = 1; i < N; i++) {
                GCD = getGCD(GCD, scanner.nextInt());
            }
            System.out.println(GCD != 1 ? -1 : 0);
        }
    }
}
