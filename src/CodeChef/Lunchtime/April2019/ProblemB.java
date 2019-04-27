package CodeChef.Lunchtime.April2019;

import sun.security.krb5.internal.crypto.Aes128;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProblemB {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] Ai = new int[N], Bi = new int[N];
            String[] S1 = bufferedReader.readLine().split(" ");
            String[] S2 = bufferedReader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                Ai[i] = Integer.parseInt(S1[i]);
            }
            for (int i = 0; i < N; i++) {
                Bi[i] = Integer.parseInt(S2[i]);
            }
            int[] r1 = new int[N], r2 = new int[N];
            int c1 = 0, c2 = 0;
            for (int i = 0; i < N; i++) {
                c1 += Ai[i];
                r1[i] = c1;
                c2 += Bi[i];
                r2[i] = c2;
            }
            int max = c1 > c2 ? c1 : c2;

            for (int i = 0; i < N; i++) {
                int l1 = r1[i];
                int l2 = c2 - r2[i];
                if (l1 + l2 > max) {
                    max = l1 + l2;
                }
            }
            System.out.println(max);
        }
    }
}
