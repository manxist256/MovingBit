package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//WORKCHEF
public class ChefAndSpecialNumbers {

    static int pos = 18;
    static int maxK = 18;
    static long DP[][][] = new long[pos][maxK][2];

    private static long digitDP(int num, int k, int cnt, int pos, int of) {
        if (pos == String.valueOf(num).length()) {
            return (cnt >= k) ? 1 : 0;
        }

        if (DP[pos][cnt][of] != -1) {
            return DP[pos][cnt][of];
        }

        long res = 0L; int maxDigit = 9;

        if (of == 0) {
            maxDigit = String.valueOf(num).charAt(pos) - 48;
        }

        for (int dgt = 0; dgt <= maxDigit; dgt++) {
            int nof = of;
            if (of == 0 && dgt < maxDigit) {
                nof = 1;
            }
            int dcnt = cnt;
            if (dgt != 0 && getN(num, pos) % dgt == 0) {
                dcnt++;
            }
            res += digitDP(num, k, dcnt, pos+1, nof);
        }

        return DP[pos][cnt][of] = res;

    }

    private static long getN(int num, int pos) {
        String j = "";
        for (int i = 0; i <= pos; i++) {
            j = j + String.valueOf(num).charAt(pos);
        }
        return Long.parseLong(j);
    }

    private static long solve(int num, int k) {
        for (int i = 0; i < 18;i++) {
            for (int j = 0; j < 18; j++) {
                DP[i][j][0] = -1;
                DP[i][j][1] = -1;
            }
        }
        return digitDP(num, k, 0, 0, 0);
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String input[] = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);
            System.out.println(solve(b, K));
//            for (int i = 0; i < 3;i++) {
//                for (int j = 0; j < 3; j++) {
//                    System.out.println(i + " " + j + " " + DP[i][j][0]);
//                    System.out.println(i + " " + j + " " + DP[i][j][1]);
//                    System.out.println("-----");
//                }
//            }
        }
    }

}
