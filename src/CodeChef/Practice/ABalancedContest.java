package CodeChef.Practice;

import java.util.Scanner;

public class ABalancedContest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), P = scanner.nextInt();
            int cw = P / 2, hp = P / 10;
            int cwc = 0, hpc = 0;
            for (int i = 0; i < N; i++) {
                int a = scanner.nextInt();
                if (a >= cw) {
                    cwc++;
                } else if (a <= hp) {
                    hpc++;
                }
            }
            System.out.println((cwc == 1 && hpc == 2) ? "yes" : "no");
        }
    }
}
