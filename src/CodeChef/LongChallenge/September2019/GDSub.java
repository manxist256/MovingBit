package CodeChef.LongChallenge.September2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class GDSub {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        String[] inputs = bufferedReader.readLine().split(" ");
        long mod = 1000000007;
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        String[] strings = bufferedReader.readLine().split(" ");
        HashSet<Integer> m1set = new HashSet<>();
        int[] Ai = new int[N];
        for (int i = 0; i < Ai.length; i++) {
            Ai[i] = Integer.parseInt(strings[i]);
            m1set.add(Ai[i]);
        }
        if (m1set.size() <= K) {
            Arrays.sort(Ai);
            long ans = 1, cum = 0;
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(Ai[0]);
            for (int i = 1; i < N; i++) {
                int val = Ai[i];
                int prevS = hashSet.size();
                hashSet.add(val);
                int currS = hashSet.size();
                boolean changed = prevS != currS;
                if (changed) {
                    cum = ans;
                }
                ans = (((ans % mod) + 1) % mod);
                ans = ((ans % mod) + (cum % mod)) % mod;
            }
            printWriter.println((ans + 1) % mod);
        } else {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                int val = Ai[i];
                if (!treeMap.containsKey(val)) {
                    treeMap.put(val, 0);
                }
                int ev = treeMap.get(val);
                treeMap.put(val, ++ev);
            }
            int segmentSize = treeMap.size(), index = 0;
            int[] segK = new int[segmentSize], segV = new int[segmentSize];
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                int Key = entry.getKey(), Value = entry.getValue();
                segK[index] = Key; segV[index++] = Value;
            }
            long[] prev = new long[segmentSize];
            int total = 0;
            for (int i = 0; i < segmentSize; i++) {
                total += segV[i];
                prev[i] = total;
            }
            for (int i = 1; i < K; i++) {
                long[] curr = new long[segmentSize];
                curr[i - 1] = prev[i  - 1];
                for (int j = i; j < segmentSize; j++) {
                    curr[j] = ((curr[j - 1] % mod) + (segV[j] % mod)) % mod;
                    long pizza = (((prev[j - 1]) % mod) * (segV[j] % mod)) % mod;
                    curr[j] = ((curr[j] % mod) + (pizza % mod)) % mod;
                }
                prev = curr;
            }
            printWriter.println((prev[segmentSize - 1] + 1) % mod);
        }
        printWriter.flush();
    }
}
