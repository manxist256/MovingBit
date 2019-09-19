package CodeChef.Practice;

import java.util.Scanner;

public class IsItACakeWalkProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int c = 0;
            for (int i = 0; i < 100; i++) {
                int t = scanner.nextInt();
                if (t <= 30) {
                    c++;
                }
            }
            System.out.println(c >= 60 ? "yes" : "no");
        }
    }
}
