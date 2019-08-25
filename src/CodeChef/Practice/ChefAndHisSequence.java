package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndHisSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
         while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int K = scanner.nextInt();
            int[] arr1 = new int[K];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = scanner.nextInt();
            }
            int c = 0; int j = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == arr1[j]) {
                    j++;
                    c++;
                    if (c == K) {
                        break;
                    }
                }
            }
            System.out.println(c == K ? "Yes" : "No");
        }
    }
}
