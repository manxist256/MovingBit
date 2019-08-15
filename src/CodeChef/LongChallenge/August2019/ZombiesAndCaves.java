//package CodeChef.LongChallenge.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class ZombiesAndCaves {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        outer : while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] Ci = bufferedReader.readLine().split(" ");
            String[] Hi = bufferedReader.readLine().split(" ");
            int[] positive = new int[N];
            int[] negative = new int[N];
            for (int i = 0; i < N; i++) {
                int lp = i - Integer.parseInt(Ci[i]);
                int rp = i + Integer.parseInt(Ci[i]);
                if (lp < 0) {
                    positive[0]++;
                } else {
                    positive[lp]++;
                }
                if (!(rp > N - 1)) {
                    negative[rp]++;
                }
            }
            int[] finalRadiation = new int[N];
            int c = 0;
            for (int i = 0; i < N; i++) {
                c += positive[i];
                finalRadiation[i] = c;
                c -= negative[i];
            }
            HashMap<Integer, Integer> HiMap = new HashMap<>(), FinalRadMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int hKey = Integer.parseInt(Hi[i]);
                if (!HiMap.containsKey(hKey)) {
                    HiMap.put(hKey, 0);
                }
                int getV = HiMap.get(hKey);
                HiMap.put(hKey, ++getV);
                int fKey = finalRadiation[i];
                if (!FinalRadMap.containsKey(fKey)) {
                    FinalRadMap.put(fKey, 0);
                }
                int getFV = FinalRadMap.get(fKey);
                FinalRadMap.put(fKey, ++getFV);
            }
            for (Map.Entry<Integer, Integer> entry : HiMap.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (!FinalRadMap.containsKey(key)) {
                    System.out.println("NO");
                    continue outer;
                } else {
                    int value2 = FinalRadMap.get(key);
                    if (value2 != value) {
                        System.out.println("NO");
                        continue outer;
                    }
                }
            }
            System.out.println("YES");
        }
    }
}
