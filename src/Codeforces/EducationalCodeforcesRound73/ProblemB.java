import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProblemB {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    private static void solve() throws Exception {
        int N = Integer.parseInt(bufferedReader.readLine());
        int flip = 0;
        for (int i = 0; i < N; i++) {
            int start = flip;
            for (int j = 0; j < N; j++) {
                printWriter.print(start == 0 ? "W" : "B");
                start = start == 0 ? 1 : 0;
            }
            printWriter.println();
            flip = flip == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(System.out);
        solve();
        printWriter.flush();
    }
}
