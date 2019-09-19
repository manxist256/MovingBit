package CodeChef.Practice;

import java.util.Scanner;

public class EasyMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int v = arr[i] * arr[j], sum = 0;
                    while (v > 0) {
                        sum += (v % 10);
                        v /= 10;
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
