package CodeChef.Practice;

import java.util.Scanner;

public class TempleLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            int ign = Integer.parseInt(scanner.nextLine());
            String[] N = scanner.nextLine().split(" ");
            if (N.length % 2 == 0) {
                System.out.println("no");
                continue;
            }
            int flip = 0;
            for (int i = 1; i < N.length; i++) {
                int c = Integer.parseInt(N[i]);
                int c_1 = Integer.parseInt(N[i - 1]);
                if (flip == 0 && !(c-c_1 == 1)) {
                    System.out.println("no");
                    continue outer;
                }
                if (flip == 1 && !(c-c_1 == -1)) {
                    System.out.println("no");
                    continue outer;
                }
                if (i == N.length / 2) {
                    flip = 1;
                }
            }
            System.out.println(Integer.parseInt(N[0]) == 1 ? "yes" : "no");
        }
    }
}
