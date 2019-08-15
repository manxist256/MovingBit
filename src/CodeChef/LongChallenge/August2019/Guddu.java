package CodeChef.LongChallenge.August2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Guddu {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] input = bufferedReader.readLine().split(" ");
            int[] a = new int[N];
            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            int[] prefix = new int[N]; prefix[0] = a[0];
            for (int i = 1; i < N; i++) {
                prefix[i] = prefix[i - 1] ^ a[i];
            }
            Map<Integer, Integer> lastIndex = new HashMap<>();
            Map<Integer, Integer> count = new HashMap<>();

            Map<Integer, Integer> savc = new HashMap<>();
            for (int i = 0; i < N; i++) {
                if (!savc.containsKey(prefix[i])) {
                    savc.put(prefix[i], 0);
                }
                int p = savc.get(prefix[i]);
                savc.put(prefix[i], ++p);
            }

            long ans = 0;
            for (int i = 0; i < N; i++) {
                if (prefix[i] == 0) {
                    ans += i;
                }
                if (!count.containsKey(prefix[i])) {
                    count.put(prefix[i], 0);
                    lastIndex.put(prefix[i], -1);
                }

                if (lastIndex.get(prefix[i]) != -1)
                    ans += ((count.get(prefix[i]) * (i - (lastIndex.get(prefix[i]) + 1)))
                        + ((savc.get(prefix[i]) - 1) * (count.get(prefix[i]) * (i - lastIndex.get(prefix[i])))));

                int t = count.get(prefix[i]);
                count.put(prefix[i], ++t);
                lastIndex.put(prefix[i], i);
                int tx = savc.get(prefix[i]);
                savc.put(prefix[i], --tx);
            }
            System.out.println(ans);
        }
    }
}
