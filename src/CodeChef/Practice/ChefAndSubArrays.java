package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndSubArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            long[] ai = new long[N];
            for (int i = 0; i < N; i++) {
                ai[i] = scanner.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                int sum = 0, mul = 1;
                for (int j = i; j < N; j++) {
                    sum += ai[j];
                    mul *= ai[j];
                    if (sum == mul) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
