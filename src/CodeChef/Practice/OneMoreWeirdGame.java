package CodeChef.Practice;

import java.util.Scanner;

public class OneMoreWeirdGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt(), M = scanner.nextInt();
            int ans = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (j == 0 && k > 0) {
                        ans++;
                    } else if (j > 0 && k == 0) {
                        ans++;
                    } else if (j > 0 && k > 0) {
                        ans += 2;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
