package CodeChef.CypherAugust;

import java.util.Scanner;

public class KDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long[] arr = new long[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLong();
            sum += arr[i];
        }
        long r = 0;
        for (int i = 0; i < K; i++) {
            r += (arr[i]);
        }
        long min = r; int ptr = 0;
        for (int i = K; i < N; i++) {
            long newV = r - arr[ptr] + arr[i];
            r -= arr[ptr];
            r += arr[i];
            ptr++;
            if (newV < min) {
                min = newV;
            }
        }
        System.out.println(sum - min);
    }
}
