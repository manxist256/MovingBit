package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TheGreatRun {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            String[] girls = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]), K = Integer.parseInt(strings[1]);
            int max = 0;
            for (int i = 0; i <= N - K; i++) {
                int t = 0;
                for (int j = i; j < i + K; j++) {
                    t += Integer.parseInt(girls[j]);
                }
                if (t > max) {
                    max = t;
                }
            }
            printWriter.println(max);
        }
        printWriter.flush();
    }
}
