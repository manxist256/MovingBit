package CodeChef.LongChallenge.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Encoding {

    static double POS = 100005;
    static long[][][] DP = new long[(int)POS][10][2];
    static long MOD = 1000000000 + 7;
    static long[] tenpow = new long[(int)POS];
    static long[] prx;

    private static long digitDP(int length, String number, int pos, int of, int prev) {
        if (pos == length)
            return 0;

        if (DP[pos][prev][of] != -1) {
            return DP[pos][prev][of];
        }

        int maxDigit = 9;

        if (of == 0) {
            maxDigit = number.charAt(pos) - 48;
        }

        long res = 0L;

        for (int dgt = 0; dgt <= maxDigit; dgt++) {
            int nof = of;
            if (of == 0 && dgt < maxDigit) {
                nof = 1;
            }

            if (pos < length - 1 && dgt > 0 && DP[pos + 1][0][of] != -1) {
                long tp = tenpow[length - ((pos+1) + 1)];
                long meck =  DP[pos+1][dgt][of] = ((DP[pos+1][0][of] % MOD) - ((((dgt % MOD) * (tp % MOD)) % MOD) * (tp % MOD)) % MOD) % MOD;
                res = ((res % MOD) + (meck % MOD)) % MOD;
            } else {
                res = ((res % MOD) + digitDP(length, number, pos + 1, nof, dgt) % MOD) % MOD;
            }

            if (prev != dgt) {
                if (nof == 1) {
                    long tp = tenpow[length - (pos + 1)];
                    res = ((res % MOD) + ((((dgt % MOD) * (tp % MOD)) % MOD) * (tp % MOD)) % MOD) % MOD;
                } else {
                    long tp = tenpow[length - (pos + 1)];
                    res = ((res % MOD) + ((((dgt % MOD) * (tp % MOD)) % MOD) * (getN(pos, number) % MOD)) % MOD) % MOD;
                }
            }
        }
        return DP[pos][prev][of] = res;

    }

    private static long getN(int pos, String number) {
        if (pos == number.length() - 1) {
            return 1;
        }
        return prx[pos + 1];
    }

    private static long solve(int length, String number) {
        prx = new long[length];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(number.charAt(i)-48);
        }
        for (int i = 0; i < length; i++) {
            BigInteger bigInteger = new BigInteger(stringBuilder.toString());
            prx[i] = bigInteger.mod(BigInteger.valueOf(MOD)).longValue() + 1;
            stringBuilder.deleteCharAt(0);
        }
        for (int i = 0; i < POS; i++) {
            for (int j = 0; j < 10; j++) {
                DP[i][j][0] = -1; DP[i][j][1] = -1;
            }
        }
        long ans = digitDP(length, number, 0, 0, 0) % MOD;
        return ans;
    }

    private static void calculateTenPow() {
        long calc = 1;
        tenpow[0] = 1;
        for (int i = 1; i < (int)POS; i++) {
            calc = ((calc % MOD) * 10) % MOD;
            tenpow[i] = calc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        calculateTenPow();
        while (T-- > 0) {
            String[] input1 = bufferedReader.readLine().split(" ");
            int lnum1 = Integer.parseInt(input1[0]);
            String num1 = input1[1];
            String[] input2 = bufferedReader.readLine().split(" ");
            int lnum2 = Integer.parseInt(input2[0]);
            String num2 = input2[1];
            BigInteger bigInteger = new BigInteger(num1);
            BigInteger bigInteger1 = bigInteger.subtract(BigInteger.ONE);
            System.out.println((MOD + solve(lnum2, num2) - solve(bigInteger1.toString().length(), bigInteger1.toString())) % MOD);
        }
    }
}