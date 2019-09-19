package CodeChef.Practice;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), K = scanner.nextInt(), V = scanner.nextInt();
            int tot = V * (N + K);
            int totad = 0;
            for (int i = 0; i < N; i++) {
                totad += scanner.nextInt();
            }
            int deletedSum = tot - totad;
            if (deletedSum <= 0 || deletedSum % K != 0) {
                System.out.println(-1);
            } else {
                System.out.println(deletedSum / K);
            }
        }
    }
}
