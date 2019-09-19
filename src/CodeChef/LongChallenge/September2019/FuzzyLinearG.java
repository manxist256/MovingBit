package CodeChef.LongChallenge.September2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FuzzyLinearG {

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");
        int Q = Integer.parseInt(bufferedReader.readLine());
        HashMap<Long, Long> map = new HashMap<>();
        long max = 0;
        for (int i = 0; i < N; i++) {
            long gcd = 0;
            if (Long.parseLong(strings[i]) > max) {
                max = Long.parseLong(strings[i]);
            }
            for (int j = i; j < N; j++) {
                gcd = gcd(gcd, Long.parseLong(strings[j]));
                if (!map.containsKey(gcd)) {
                    map.put(gcd, 0L);
                }
                long ev = map.get(gcd);
                map.put(gcd, ++ev);
            }
        }
        HashMap<Integer, Long> map1 = new HashMap<>();
        while (Q-- > 0) {
            int K = Integer.parseInt(bufferedReader.readLine());
            if (map1.containsKey(K)) {
                printWriter.println(map1.get(K));
                continue;
            }
            long ans = 0;
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                long gcd = entry.getKey(); long cnt = entry.getValue();
                if (K % gcd == 0) {
                    ans += cnt;
                }
            }
            map1.put(K, ans);
            printWriter.println(ans);
        }
        printWriter.flush();
    }
}
