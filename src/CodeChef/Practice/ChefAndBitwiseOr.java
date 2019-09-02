package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndBitwiseOr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int or = 0;
            for (int i = 0; i < N; i++) {
                or = or | scanner.nextInt();
            }
            System.out.println(or);
        }
    }
}
