//package CodeChef.LongChallenge.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Football {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] gs = new int[N], gf = new int[N];
            String[] gsl = bufferedReader.readLine().split(" "), gfl = bufferedReader.readLine().split(" ");
            int max = 0;
            for (int i = 0; i < N; i++) {
                gs[i] = Integer.parseInt(gsl[i]);
                gf[i] = Integer.parseInt(gfl[i]);
                int points = (gs[i] * 20) - (gf[i] * 10);
                if (points > max) {
                    max = points;
                }
            }
            System.out.println(max);
        }
    }
}
