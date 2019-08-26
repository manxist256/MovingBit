package CodeChef.Practice;

import java.util.Scanner;

public class DownloadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), K = scanner.nextInt();
            int[] Ti = new int[N], Pi = new int[N];
            for (int i = 0; i < N; i++) {
                Ti[i] = scanner.nextInt();
                Pi[i] = scanner.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                if ((K - Ti[i]) >= 0) {
                    K -= Ti[i];
                } else if ((K - Ti[i]) < 0) {
                    int rem = Ti[i] - K;
                    ans += rem * Pi[i];
                    K = 0;
                }
            }
            System.out.println(ans);
        }
    }
}
