package CodeChef.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class ChefAndEid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i+1]-arr[i] < ans) {
                    ans = arr[i+1]-arr[i];
                }
            }
            System.out.println(ans);
        }
    }
}
