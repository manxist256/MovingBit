import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class ProblemB {

    static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b,a % b);
    }

    private static HashSet<Long> getFactors(long n) {
        HashSet<Long> factors = new HashSet<>();
        for (long i = 1; i <= (long)Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n/i);
            }
        }
        return factors;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int K = Integer.parseInt(bufferedReader.readLine());
        long[][] arr = new long[K][K];
        for (int i = 0; i < K; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                arr[i][j] = Long.parseLong(strings[j]);
            }
        }
        long gcd = arr[0][1];
        for (int i = 0; i  <= 0; i++) {
            for (int j = 0; j < K; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                gcd = gcd(arr[i][j], gcd);
            }
        }
        HashSet<Long> fact = getFactors(gcd);
        outer : for (Long l : fact) {
            long newarr[] = new long[K];
            newarr[0] = l;
            for (int i = 1; i < K; i++) {
                newarr[i] = arr[0][i] / l;
                //System.out.println(newarr[i]);
            }
            long[][] blur = new long[K][K];
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    if (i == j) {
                        blur[i][j] = 0;
                        continue;
                    }
                    blur[i][j] = newarr[i] * newarr[j];
                }
            }
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    if (arr[i][j] == blur[i][j]) {
                        continue;
                    } else {
                        continue outer;
                    }
                }
            }
            for (int i = 0; i < K; i++) {
                printWriter.print(newarr[i] + " ");
            }
        }
        printWriter.flush();
    }
}
