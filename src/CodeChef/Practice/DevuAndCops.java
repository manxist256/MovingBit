package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DevuAndCops {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String input[] = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]), m = Integer.parseInt(input[2]);
            String cops[] = bufferedReader.readLine().split(" ");
            int[] r = new int[100];
            for (int i = 0; i < x; i++) {
                int hn = Integer.parseInt(cops[i]);
                int rangeL = (hn - 1) - (y * m);
                int rangeR = (hn - 1) + (y * m);
                r[rangeL < 0 ? 0 : rangeL]++;
                if (!(rangeR >= 99)) {
                    r[rangeR + 1]--;
                }
            }
            int c = 0;
            for (int i = 0; i < 100; i++) {
                c += r[i];
                r[i] = c;
            }
            int ans = 0;
            for (int i = 0; i < 100; i++) {
                if (r[i] == 0) {
                    ans++;
                }
            }
            printWriter.println(ans);
        }
        printWriter.flush();
    }
}
