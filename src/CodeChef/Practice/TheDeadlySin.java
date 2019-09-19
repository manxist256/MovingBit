package CodeChef.Practice;

import java.util.Scanner;

public class TheDeadlySin {

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n1 = scanner.nextInt(), n2 = scanner.nextInt();
            System.out.println((long)gcd(n1, n2)*2);
        }
    }
}
