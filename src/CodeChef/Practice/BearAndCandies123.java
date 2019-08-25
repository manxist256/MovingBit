package CodeChef.Practice;

import java.util.Scanner;

public class BearAndCandies123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int n = 1;
            while (true) {
                if (!(A >= n)) {
                    System.out.println("Bob");
                    break;
                }
                A -= n;
                n++;
                if (!(B >= n)) {
                    System.out.println("Limak");
                    break;
                }
                B -= n;
                n++;
            }
        }
    }
}
