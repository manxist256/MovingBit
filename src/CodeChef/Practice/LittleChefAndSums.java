package CodeChef.Practice;

import java.util.Scanner;

public class LittleChefAndSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            long ps[] = new long[N];
            long ss[] = new long[N];
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    ps[i] = arr[i];
                } else {
                    ps[i] = arr[i] + ps[i - 1];
                }
            }
            for (int i = N - 1; i >= 0; i--) {
                if (i == N - 1) {
                    ss[i] = arr[i];
                } else {
                    ss[i] = arr[i] + ss[i + 1];
                }
            }
            long min = Long.MAX_VALUE; int index = -1;
            for (int i = 0; i < N; i++) {
                if (ps[i] + ss[i] < min) {
                    min = ps[i] + ss[i];
                    index = i + 1;
                }
            }
            System.out.println(index);
        }
    }
}
