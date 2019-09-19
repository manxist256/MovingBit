package CodeChef.Practice;

import java.util.Scanner;

public class NaiveChef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), A = scanner.nextInt(), B = scanner.nextInt();
            int ac = 0, bc = 0;
            for (int i = 0; i < N; i++) {
                int v = scanner.nextInt();
                if (v == A) {
                    ac++;
                }
                if (v == B) {
                    bc++;
                }
            }
            System.out.println(((double)ac/N)*((double)bc/N));
        }
    }
}
