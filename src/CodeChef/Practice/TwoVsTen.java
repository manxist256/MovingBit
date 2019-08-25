package CodeChef.Practice;

import java.util.Scanner;

public class TwoVsTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long x = scanner.nextLong();
            System.out.println(x % 10 == 0 ? 0 : (x % 5 == 0 ? 1 : -1));
        }
    }
}
