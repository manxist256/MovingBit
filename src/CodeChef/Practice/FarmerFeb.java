package CodeChef.Practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FarmerFeb {

    private static HashSet<Integer> sieve() {
        int N = 2200;
        HashSet<Integer> p = new HashSet<>();
        int[] arr = new int[N + 1];
        Arrays.fill(arr, 1);
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;
            for (int j = 2; i * j <= N; j++) {
                arr[i * j] = 0;
            }
        }
        for (int i = 0; i  < arr.length; i++) {
            if (arr[i] == 1) {
                p.add(i);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        HashSet<Integer> primes = sieve();
        while (T-- > 0) {
            int c = scanner.nextInt() + scanner.nextInt();
            for (int i = 1; i < 100; i++) {
                if (primes.contains(c+i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
