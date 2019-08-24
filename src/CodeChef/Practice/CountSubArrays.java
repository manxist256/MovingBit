package CodeChef.Practice;

import java.util.Scanner;

public class CountSubArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int i = 0; long ans = 0;
            for (int j = 1; j < N; j++) {
                if (arr[j] < arr[j - 1]) {
                    long p = j - i;
                    ans += ((p * (p + 1)) / 2);
                    i = j;
                }
            }
            long l = arr.length - i;
            ans += ((l * (l + 1)) / 2);
            System.out.println(ans);
        }
    }
}
