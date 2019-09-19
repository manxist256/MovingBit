package CodeChef.Practice;

import java.util.Scanner;

public class TwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long A = scanner.nextLong(), B = scanner.nextLong(), N = scanner.nextLong();
            if (N % 2 != 0) {
                A *= 2;
            }
            System.out.println(Math.max(A, B)/Math.min(A, B));
        }
    }
}
