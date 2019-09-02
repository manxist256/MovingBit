package CodeChef.Practice;

import java.util.HashMap;
import java.util.Scanner;

public class RandomPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int sum = arr[i] + arr[j];
                    if (!map.containsKey(sum)) {
                        map.put(sum, 0);
                    }
                    int ec = map.get(sum);
                    map.put(sum, ++ec);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println((double)map.get(max) / ((N*(N-1))/2));
        }
    }
}
