package CodeChef.Encoding2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LazyChoze {
    public static void main(String[] args) throws IOException {
        long mod = 1000000007;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(s[0]); int K = Integer.parseInt(s[1]);
            Set<Integer> wet = new HashSet<>();
            String[] wets = bufferedReader.readLine().split(" ");
            for (int i = 0; i < K; i++) {
                wet.add(Integer.parseInt(wets[i]));
            }
            long[] arr = new long[N];
            if (wet.contains(1) && wet.contains(2) && wet.contains(3)) {
                System.out.println(0);
                continue;
            }
            for (int i = 0; i < N; i++) {
                if (i == 0 && !wet.contains(1)) {
                    arr[0] = 1;
                }
                if (i == 1 && !wet.contains(2)) {
                    arr[1] = arr[0];
                    arr[1]++;
                }
                if (i == 2 && !wet.contains(3)) {
                    arr[2] = arr[1] + arr[0];
                    arr[2]++;
                }
                if (i > 2 && !wet.contains(i + 1)) {
                    arr[i] = ((((arr[i - 1] % mod) + (arr[i-2] % mod)) % mod) + (arr[i-3] % mod)) % mod;
                }
            }
            System.out.println(arr[N - 1]);
        }
    }
}
