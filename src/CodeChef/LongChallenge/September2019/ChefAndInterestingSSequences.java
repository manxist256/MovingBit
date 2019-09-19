package CodeChef.LongChallenge.September2019;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndInterestingSSequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), K = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[N];
            int lv = -1;
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 0);
                }
                int ev = map.get(arr[i]);
                map.put(arr[i], ++ev);
            }
            Arrays.sort(arr);
            int r = 0;
            for (int i = 0; i < K; i++) {
                lv = arr[i];
            }
            for (int i = 0; i < K; i++) {
                if (arr[i] == lv) {
                    r++;
                }
            }
            //System.out.println(map);
            int n = map.get(lv);
            BigInteger ans = fact(n).divide(fact(n-r).multiply(fact(r)));
            System.out.println(ans);
        }
    }
    private static BigInteger fact(int N) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
