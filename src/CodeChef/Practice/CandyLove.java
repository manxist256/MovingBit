package CodeChef.Practice;

import java.util.Scanner;

public class CandyLove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum % 2 != 0 ? "YES" : "NO");
        }
    }
}
