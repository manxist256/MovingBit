package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndGift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int n = scanner.nextInt();
            int k  = scanner.nextInt();
            int a = 0; int d = 0;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] % 2 == 0) {
                    d++;
                }
            }
            if (k == 0) {
                if (d == n)
                    System.out.println("NO");
                else
                    System.out.println("YES");
                continue outer;
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    a++;
                }
                if (a == k) {
                    System.out.println("YES");
                    continue outer;
                }
            }
            System.out.println("NO");
        }
    }
}
