//package CodeChef.Lunchtime.April2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class ProblemA {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T--> 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            HashMap<String, Integer> fc = new HashMap<>();
            String[] fn = new String[N];
            String[] ln = new String[N];
            for (int i = 0; i < N; i++) {
                String input[] = bufferedReader.readLine().split(" ");
                fn[i] = input[0].trim();
                ln[i] = input[1].trim();
                if (!fc.containsKey(fn[i])) {
                    fc.put(fn[i], 0);
                }
                int ev = fc.get(fn[i]);
                fc.put(fn[i], ++ev);
            }
            for (int i = 0; i < N; i++) {
                int count = fc.get(fn[i]);
                if (count == 1) {
                    System.out.println(fn[i]);
                } else {
                    System.out.println(fn[i] + " " + ln[i]);
                }
            }
        }
    }
}
