package CodeChef.Practice;

import java.io.PrintWriter;
import java.util.Scanner;

public class AlternatingSubArrayPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            int N = scanner.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int curr = 1;
            int[] ans = new int[N];
            ans[N - 1] = 1;
            for (int i = N - 2; i >= 0; i--) {
                if ((arr[i] > 0 && arr[i + 1] < 0) || (arr[i] < 0 && arr[i + 1] > 0)) {
                    curr++;
                } else {
                    curr = 1;
                }
                ans[i] = curr;
            }
            for (int i = 0; i < ans.length; i++) {
                printWriter.print(ans[i] + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
