import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProblemE {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    private static void solve() throws Exception {
        int T = Integer.parseInt(bufferedReader.readLine());
        outer : while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            String f = bufferedReader.readLine();
            int ss = 0;
            int maxss = 0;
            for (int i = 0; i < f.length(); i++) {
                if (f.charAt(i) == '.') {
                    ss++;
                } else {
                    int reg = ss - (a + (b - 1));
                    if (reg >= 2 * b) {
                        printWriter.println("NO");
                        continue outer;
                    }
                    if (maxss < ss) {
                        maxss = ss;
                    }
                    ss = 0;
                }
            }
            int reg = ss - (a + (b - 1));
            if (reg >= 2 * b) {
                printWriter.println("NO");
                continue outer;
            }
            if (maxss < ss) {
                maxss = ss;
            }
            if (maxss < a) {
                printWriter.println("NO");
                continue outer;
            }
            printWriter.println("YES");
        }
    }

    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(System.out);
        solve();
        printWriter.flush();
    }
}
