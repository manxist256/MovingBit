import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProblemC {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    private static void solve() throws Exception {
        int Q = Integer.parseInt(bufferedReader.readLine());
        while (Q-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int c = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);
            int x = Integer.parseInt(strings[2]);
            long ans = x;
            if (x <= c && x <= m) {
                c -= x; m -= x;
                int max = Math.max(c, m);
                int min = Math.min(c, m);
                if (min * 2 <= max) {
                    printWriter.println(x + min);
                }
                else {
                    printWriter.println(ans + (c+m)/3);
                }
            } else {
                printWriter.println(Math.min(c, m));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(System.out);
        solve();
        printWriter.flush();
    }
}
