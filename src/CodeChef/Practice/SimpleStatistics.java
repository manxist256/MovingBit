package CodeChef.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int[] arr = new int[scanner.nextInt()];
            int K = scanner.nextInt();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr); int sumExcluding2K = 0;
            for (int i = K; i < arr.length - K; i++) {
                sumExcluding2K += arr[i];
            }
            System.out.println((double)sumExcluding2K / (arr.length - 2 * K));
        }
    }
}
