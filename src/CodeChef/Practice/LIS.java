package CodeChef.Practice;

import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < N; i++) {
                stringBuilder.append(scanner.nextInt());
            }
            System.out.println(stringBuilder);
        }
    }
}
