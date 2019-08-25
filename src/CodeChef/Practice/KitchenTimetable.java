package CodeChef.Practice;

import java.util.Scanner;

public class KitchenTimetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] Ai = new int[N], Bi = new int[N];
            for (int i = 0; i < N; i++) {
                Ai[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                Bi[i] = scanner.nextInt();
            }
            long ans = 0;
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    if (Bi[0] <= Ai[0]) {
                        ans++;
                    }
                } else {
                    if (Bi[i] <= (Ai[i] - Ai[i - 1])) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
