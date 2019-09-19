package CodeChef.Practice;

import java.util.Scanner;

public class ValidStackOps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int a = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 1) {
                    a++;
                } else {
                    if (a > 0) {
                        a--;
                    } else {
                        System.out.println("Invalid");
                        continue outer;
                    }
                }
            }
            System.out.println("Valid");
        }
    }
}
