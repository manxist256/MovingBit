package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SplitStones {

    private static boolean splitable(long splitter, long p1, long p2, long x, long y) {
        long c1a = x - p1, c1b = y - p2;
        long c2a = x - p2, c2b = y - p1;
        return (c1a + c1b == splitter && c1a >= 0 && c1b >= 0) || (c2a + c2b == splitter && c2a >= 0 && c2b >= 0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        outer : while (T-- > 0) {
            String[] strings =  bufferedReader.readLine().split(" ");
            long a = Long.parseLong(strings[0]);
            long b = Long.parseLong(strings[1]);
            long c = Long.parseLong(strings[2]);
            long x = Long.parseLong(strings[3]);
            long y = Long.parseLong(strings[4]);
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    if (splitable(a, b, c, x, y)) {
                        printWriter.println("YES");
                        continue outer;
                    }
                } else if (i == 2) {
                    if (splitable(b, a, c, x, y)) {
                        printWriter.println("YES");
                        continue outer;
                    }
                } else {
                    if (splitable(c, a, b, x, y)) {
                        printWriter.println("YES");
                        continue outer;
                    }
                }
            }
            printWriter.println("NO");
        }
        printWriter.flush();
    }
}
