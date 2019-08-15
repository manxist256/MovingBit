package DynamicProgramming.DigitDP;

import java.util.Scanner;

public class SumOfDigitsBetweenAandB {

    static int pos = 18;
    static long DP[][] = new long[pos][2];
    //0 = overflow
    //1 = not overflow

    private static long solve(long num, int pos, int of) {
        if (pos == String.valueOf(num).length() - 1) {
            if (of == 0) {
                int c = String.valueOf(num).charAt(pos) - 48;
                return DP[pos][of] = (c * (c + 1)) / 2;
            } else {
                return DP[pos][of] = 45;
            }
        }
        if (pos == String.valueOf(num).length()) {
            return 0;
        }
        if (DP[pos][of] != -1) {
            return DP[pos][of];
        }

        int Max_Digit = 9;

        if (of == 0) Max_Digit = String.valueOf(num).charAt(pos) - 48;

        long res = 0L;

        for (int dgt = 0; dgt <= Max_Digit; dgt++) {
            int nof = of;
            if (of == 0 && dgt < Max_Digit) {
                nof = 1;
            }
            res += solve(num, pos + 1, nof);
            if (nof == 1) {
                res += (dgt * Math.pow(10, ((String.valueOf(num).length() - 1) - pos)));
            } else {
                res += (dgt * (getN(pos + 1, num) + 1));
            }
        }
        return DP[pos][of] = res;
    }

    private static long getN(int pos, long num) {
        String s = "";
        for (int i = pos; i < String.valueOf(num).length(); i++) {
            s += String.valueOf(num).charAt(i);
        }
        return Long.parseLong(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long /*a = scanner.nextByte(),*/ b = scanner.nextLong();
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[i].length; j++) {
                DP[i][j] = -1;
            }
        }
        System.out.println(solve(b, 0, 0));
    }
}
