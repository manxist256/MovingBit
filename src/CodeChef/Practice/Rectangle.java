package CodeChef.Practice;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            if ((a == b && c == d)
                    || (a == c && b == d)
                    || (a == d && b == c)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
