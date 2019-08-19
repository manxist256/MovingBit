package CodeChef.Cookoff.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problem3{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int Q = Integer.parseInt(strings[1]);
            String s = bufferedReader.readLine();
            int[] pf = new int[N];
            for (int i = 0; i < N - 2; i++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);
                char c3 = s.charAt(i + 2);
                if (c1 == c2 || c1 == c3 || c2 == c3) {
                    pf[i + 2] = 1;
                }
            }
            int cum = 0;
            int[] cf = new int[N];
            for (int i = 0; i < pf.length; i++) {
                if (pf[i] == 1) {
                    cum++;
                }
                cf[i] = cum;
            }
            for (int i = 0; i < Q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                int L = Integer.parseInt(query[0]) - 1;
                int R = Integer.parseInt(query[1]) - 1;
                if (N >= 3 && (R - L >= 2)) {
                    //cf[R - 1] - cf[L] > 0
                    //int minus = (pf[L + 1] + pf[L]);
                    int v = (cf[R] - cf[L + 2]);
                    if (((v > 0) || (v == 0 && cf[L + 1] != cf[R])))
                        writer.println("YES");
                    else
                        writer.println("NO");
                } else {
                    writer.println("NO");
                }
            }
            writer.flush();
        }
    }
}
