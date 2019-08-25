package CodeChef.Encoding2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GCDandLCM {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] input = bufferedReader.readLine().split(" ");
            long[] numbers = new long[N];
            HashMap<Long, Integer> counts = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
                if (!counts.containsKey(numbers[i])) {
                    counts.put(numbers[i], 0);
                }
                int ev = counts.get(numbers[i]);
                counts.put(numbers[i], ++ev);
            }
            long ans = 0;
            for (int i = 0; i < N; i++) {
                long doubleValue = numbers[i] * 2;
                if (counts.containsKey(doubleValue)) {
                    int cnt = counts.get(doubleValue);
                    ans += cnt;
                }
            }
            System.out.println(ans);
        }
    }
}
