package CodeChef.Practice;

import java.util.Scanner;

public class GoodSet {

    private static void makeGoodSet(long[] arr) {
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] arr = new long[100];
        makeGoodSet(arr);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
