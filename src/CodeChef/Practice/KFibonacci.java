package CodeChef.Practice;

import java.util.Scanner;

public class KFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod = 1000000007;
        int N = scanner.nextInt(), K = scanner.nextInt();
        if (K >= N) {
            System.out.println(1);
        } else {
            int sum;
            int[] arr = new int[N];
            for (int i = 0; i < K; i++) {
                arr[i] = 1;
            }
            sum = K; int ptr = 0;
            for (int i = K; i < N; i++) {
                arr[i] = sum;
                sum = ((sum % mod) - (arr[ptr] % mod)) % mod;
                sum = ((sum % mod) + (arr[i] % mod)) % mod;
                ptr++;
            }
            System.out.println(arr[N-1]);
        }
    }
}
