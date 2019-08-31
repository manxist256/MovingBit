package CodeChef.Practice;

import java.util.Scanner;

public class BearAndLadder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long n1 = scanner.nextLong(), n2 = scanner.nextLong();
            if (n1 % 2 != 0) {
                long poss1 = n1 + 1, poss2 = n1 - 2, poss3 = n1 + 2;
                if (n2 == poss1 || n2 == poss2 || n2 == poss3) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                long poss1 = n1 - 1, poss2 = n1 - 2, poss3 = n1 + 2;
                if (n2 == poss1 || n2 == poss2 || n2 == poss3) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
