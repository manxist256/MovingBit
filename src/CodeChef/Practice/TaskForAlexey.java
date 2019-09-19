package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class TaskForAlexey {
    static Set<Long> factors(long number) {
        Set<Long> factors = new HashSet<>();
        long sqrt = (long)(Math.sqrt(number) + 1);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                factors.add((long)i);
                factors.add(number / i);
            }
        }
        return factors;
    }

    static long getGCD(long a, long b) {
        if (b == 0) return a;
        else return getGCD(b,a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] strings = bufferedReader.readLine().split(" ");
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(strings[i]);
            }
            long min = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    long GCD = getGCD(arr[i], arr[j]);
                    long L = arr[i]/GCD * arr[j];
                    if (L < min) {
                        min = L;
                    }
                }
            }
            printWriter.println(min);
        }
        printWriter.flush();
    }
}
