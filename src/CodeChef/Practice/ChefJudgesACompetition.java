package CodeChef.Practice;

import java.util.Scanner;

public class ChefJudgesACompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int s1 = 0, m1 = 0, s2 = 0, m2 = 0;
            for (int i = 0; i < N; i++) {
                int v = scanner.nextInt();
                if (v > m1) {
                    m1 = v;
                }
                s1 += v;
            }
            for (int i = 0; i < N; i++) {
                int v = scanner.nextInt();
                if (v > m2) {
                    m2 = v;
                }
                s2 += v;
            }
            System.out.println((s1-m1) > (s2-m2) ? "Bob" : ((s1-m1) < (s2-m2) ? "Alice" : "Draw"));
        }
    }
}
