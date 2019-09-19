package CodeChef.LongChallenge.September2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChefDesignedANetwork {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            long N = Long.parseLong(strings[0]);
            long M = Long.parseLong(strings[1]);
            if (M < N - 1) {
                printWriter.println(-1);
            } else {
                if ((M > (N * (N - 1)) / 2 + N)) {
                    printWriter.println(-1);
                } else if (M == 0) {
                    if (N == 1) {
                        printWriter.println(0);
                    } else {
                        printWriter.println(-1);
                    }
                } else {
                    long ans;
                    if (N == 1 && M == 1 || N == 2 && M == 1) {
                        printWriter.println(1);
                        continue;
                    }
                    if (N == M || N + 1 == M || N - 1 == M) {
                        printWriter.println(2);
                        continue;
                    }
                    ans = 2;
                    M -= N;
                    if (M > 0) {
                        M -= N;
                        ans++;
                    }
                    if (M > 0) {
                        if (N % 2 == 0) {
                            long cabUsedPerStep = N / 2;
                            long stepsHappened = M / cabUsedPerStep;
                            ans += stepsHappened + (M % cabUsedPerStep == 0 ? 0 : 1);
                        } else {
                            long stepsHappened = M / N;
                            ans += (2 * stepsHappened);
                            M -= (stepsHappened * N);
                            if (M > 0) {
                                M -= N / 2;
                                ans++;
                                if (M > 0) {
                                    ans++;
                                }
                            }
                        }
                    }
                    printWriter.println(ans);
                }
            }
        }
        printWriter.flush();
    }
}