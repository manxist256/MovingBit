package CodeChef.LongChallenge.September2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EasyFib {

    static long[] generateFib() {
        long f = 0, s = 1, t;
        long[] arr = new long[60];
        arr[0] = f;
        arr[1] = s;
        for (int i = 2; i < 60; i++) {
            t = f + s;
            arr[i] = t % 10;
            f = s;
            s = t;
        }
        return arr;
    }

    private static long pos(long N) {
        for (int i = 0; i < 64; i++) {
            long v1 = (long)Math.pow(2, i);
            long v2 = (long)Math.pow(2, i+1);
            if (N >= v1 && N < v2) {
                return v1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        long[] fib = generateFib();

        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(bufferedReader.readLine());
            if (N == 1) {
                printWriter.println(0);
                continue;
            }
            long p = pos(N);
            long pk = p % 60;
            printWriter.println(fib[(int)pk - 1]);
        }
        printWriter.flush();
    }
}
