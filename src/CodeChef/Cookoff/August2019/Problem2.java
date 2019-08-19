package CodeChef.Cookoff.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] pizza = new int[N][N];
            for (int i = 0; i < N; i++) {
                String v = bufferedReader.readLine();
                for (int j = 0; j < N; j++) {
                    pizza[i][j] = v.charAt(j) - 48;
                }
            }
            int p1 = 0, p2 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (pizza[i][j] == 1) {
                        if (j <= (N - 1) / 2) {
                             p1++;
                        } else {
                            p2++;
                        }
                    }
                }
            }
            int absd = Math.abs(p1 - p2);
            for (int i = 0; i < N; i++) {
                int r1 = 0, r2 = 0;
                for (int j = 0; j < N; j++) {
                    if (pizza[i][j] == 1) {
                        if (j <= (N - 1) / 2) {
                            r1 += 1;
                        } else {
                            r2 += 1;
                        }
                    }
                }
                int check = Math.abs((p1-r1+r2)-(p2-r2+r1));
                if (check <= absd) {
                    absd = check;
                }
            }
            System.out.println(absd);
        }
    }
}
