package CodeChef.Lunchtime.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DestroyCells {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String string[] = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(string[0]);
            int M = Integer.parseInt(string[1]);
            printWriter.print(N * M + " ");
            for (int i = 1; i < (N * M); i++) {
                int[][] arr = new int[N][M];
                //hero 1
                int g1 = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (g1 % (i + 1) == 0) {
                            arr[j][k] = 1;
                        }
                        g1++;
                    }
                }
                int g2 = 0;
                //hero 2
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < N; k++) {
                        if (g2 % (i + 1) == 0) {
                            arr[k][j] = 1;
                        }
                        g2++;
                    }
                }
                int cc = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (arr[j][k] == 1) {
                            cc++;
                        }
                    }
                }
                printWriter.print(cc + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
