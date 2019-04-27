package CodeChef.Lunchtime.April2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProblemC {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] Ai = new int[N];
            String[] S1 = bufferedReader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                Ai[i] = Integer.parseInt(S1[i]);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= 1000; i++) {
                int c = 0;
                for (int j = 0; j < N; j++) {
                    c += (Ai[j] ^ i);
                }
                if (c < min) {
                    min = c;
                }
            }
            System.out.println(min);
        }
    }
}
