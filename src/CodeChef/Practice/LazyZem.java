package CodeChef.Practice;

import java.util.Scanner;

public class LazyZem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long N = scanner.nextLong(), B = scanner.nextLong(), M = scanner.nextLong();
            long ans = 0;
            while (N > 0) {
                if (N % 2 == 0) {
                    ans += (M * (N / 2));
                    N -= (N / 2);
                } else {
                    long solved = (N + 1) / 2;
                    ans += (solved * M);
                    N -= solved;
                }
                M *= 2;
                if (N != 0)
                    ans += B;
            }
            System.out.println(ans);
        }
    }
}
