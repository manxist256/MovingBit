package CodeChef.Practice;

import java.util.Scanner;

public class CouponSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int c1 = -1, c2 = -1, c3 = -1, m1 = -1, m2 = -1, m3 = -1;
            for (int i = 0; i < N; i++) {
                int city = scanner.nextInt();
                int l = scanner.nextInt();
                int disc = scanner.nextInt();
                if (l == 1) {
                    if (disc > m1) {
                        m1 = disc;
                        c1 = city;
                    } else if (disc == m1) {
                        if (city < c1) {
                            c1 = city;
                        }
                    }
                } else if (l == 2) {
                    if (disc > m2) {
                        m2 = disc;
                        c2 = city;
                    }
                    else if (disc == m2) {
                        if (city < c2) {
                            c2 = city;
                        }
                    }
                } else if (l == 3) {
                    if (disc > m3) {
                        m3 = disc;
                        c3 = city;
                    }
                    else if (disc == m3) {
                        if (city < c3) {
                            c3 = city;
                        }
                    }
                }
            }
            System.out.println(m1 + " " + c1);
            System.out.println(m2 + " " + c2);
            System.out.println(m3 + " " + c3);
        }
    }
}
