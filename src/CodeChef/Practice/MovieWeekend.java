package CodeChef.Practice;

import java.util.Scanner;

public class MovieWeekend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] li = new int[N], ri = new int[N];
            for (int i = 0; i < N; i++) {
                li[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                ri[i] = scanner.nextInt();
            }
            int max = -1, ans = 0, oldRi = 0;
            for (int i = 0; i < N; i++) {
                int v = li[i] * ri[i];
                if (v > max) {
                    max = v;
                    ans = i + 1;
                    oldRi = ri[i];
                } else if (v == max) {
                    if (oldRi < ri[i]) {
                        ans = i + 1;
                        oldRi = ri[i];
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
