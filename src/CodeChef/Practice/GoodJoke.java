package CodeChef.Practice;

import java.util.Scanner;

public class GoodJoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int xor = 0;
            for (int i = 1; i <= N; i++) {
                int j1 = scanner.nextInt();
                int j2 = scanner.nextInt();
                xor ^= i;
            }
            System.out.println(xor);
        }
    }
}
