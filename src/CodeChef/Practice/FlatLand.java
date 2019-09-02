package CodeChef.Practice;

import java.util.Scanner;

public class FlatLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int ite = 0;
            while (N > 0) {
                int K = (int)Math.sqrt(N);
                N = N - K * K;
                ite++;
            }
            System.out.println(ite);
        }
    }
}
