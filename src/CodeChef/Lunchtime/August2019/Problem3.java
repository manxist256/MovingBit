package CodeChef.Lunchtime.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            String input[] = bufferedReader.readLine().split(" ");
            long N = Long.parseLong(input[0]);
            long Q = Long.parseLong(input[1]);
            long K = Long.parseLong(input[2]);
            long L = Long.parseLong(input[3]);
            long R = Long.parseLong(input[4]);
            long[] Ci = new long[(int)N], Pi = new long[(int)N];
            for (int i = 0; i  <N; i++) {
                String[] CiPi = bufferedReader.readLine().split(" ");
                Ci[i] = Long.parseLong(CiPi[0]);
                Pi[i] = Long.parseLong(CiPi[1]);
            }
            for (int M = 1; M <= Q; M++) {
                long min = Long.MAX_VALUE;
                for (int i = 0; i < N; i++) {
                    if (Ci[i] > (K + 1)) {
                        long a = Ci[i] - (K + 1);
                        long j = K;
                        if (M <= a) {
                            j = Ci[i] - M;
                        }
                        if (j >= L && j <= R) {
                            if (Pi[i] < min) {
                                min = Pi[i];
                            }
                        }
                    } else if (Ci[i] < (K - 1)) {
                        long a = (K - 1) - Ci[i];
                        long j = K;
                        if (M <= a) {
                            j = Ci[i] + M;
                        }
                        if (j >= L && j <= R) {
                            if (Pi[i] < min) {
                                min = Pi[i];
                            }
                        }
                    } else {
                        if (K >= L && K <= R) {
                            if (Pi[i] < min) {
                                min = Pi[i];
                            }
                        }
                    }
                }
                printWriter.print(min == Long.MAX_VALUE ? -1 + " " : min + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
