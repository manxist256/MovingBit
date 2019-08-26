package CodeChef.Practice;

import java.util.Scanner;

public class DevuAndGrapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            long ans = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] % K == 0) {
                    continue;
                }
                long div = arr[i] / K;
                if (div == 0) {
                    ans += (K - arr[i]);
                    continue;
                }
                long mul = div * K;
                long mul2 = (div + 1) * K;
                ans += Math.min(arr[i] - mul, mul2 - arr[i]);
            }
            System.out.println(ans);
        }
    }
}
