package CodeChef.Practice;

import java.util.Scanner;

public class StrangeOps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += scanner.nextInt();
            }
            if (sum % 2 == 0 && K == 1) {
                System.out.println("odd");
            } else {
                System.out.println("even");
            }
        }
    }
}
