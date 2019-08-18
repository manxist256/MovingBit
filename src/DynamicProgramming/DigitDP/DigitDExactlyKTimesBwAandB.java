package DynamicProgramming.DigitDP;

import java.util.Scanner;

public class DigitDExactlyKTimesBwAandB {

    static int pos = 18;
    static int digitbefore = 18;
    static int tight = 2;
    static long DP[][][] = new long[pos][digitbefore][tight];

    private static long digitDP(long a, int pos, int cnt, int of, long d, long k) {
        if (DP[pos][cnt][of] != -1) {
            return DP[pos][cnt][of];
        }

        if (pos == String.valueOf(a).length()) {
            return (cnt == k) ? 1 : 0;
        }

        long res = 0L;

        int Max_Digit = 9;

        if (of == 0) {
            Max_Digit = String.valueOf(a).charAt(pos) - 48;
        }

        for (int dgt = 0; dgt <= Max_Digit; dgt++) {
            int nof = of;
            if (dgt < Max_Digit && nof == 0) {
                nof = 1;
            }
            int dcnt = cnt;
            if (dgt == d) {
                dcnt++;
            }
            res += digitDP(a, pos + 1, dcnt, nof, d, k);
        }
        return DP[pos][cnt][of] = res;
    }

    private static long solve(long a, long d, long k) {
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[i].length; j++) {
                DP[i][j][0] = -1;
                DP[i][j][1] = -1;
            }
        }
        return digitDP(a, 0, 0, 0, d, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong(), b = scanner.nextLong();
        long d = scanner.nextLong(), k = scanner.nextLong();
        System.out.println(solve(b, d, k) - solve(a - 1, d, k));
    }
}
