package CodeChef.Alkhwarizm2019;

import java.util.Scanner;

class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), K = scanner.nextInt();
        long[] Ai = new long[N], Bi = new long[N], Ci = new long[N];

        for (int i = 0; i < N; i++) {
            Ai[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            Bi[i] = scanner.nextInt();
        }

        long total = 0;

        for (int i = 0; i < N; i++) {
            Ci[i] = total + Ai[i] * Bi[i];
            total = Ci[i];
        }

        for (int i = 0; i < K; i++) {
            int L = scanner.nextInt(), R = scanner.nextInt();
            if (L == 1) {
                System.out.println(Ci[R - 1]);
            } else {
                System.out.println(Ci[R - 1] - Ci[L - 2]);
            }
        }

    }
}
