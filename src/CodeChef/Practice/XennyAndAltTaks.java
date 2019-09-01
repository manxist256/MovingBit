package CodeChef.Practice;

import java.util.Scanner;

public class XennyAndAltTaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] a = new int[N], b = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = scanner.nextInt();
            }
            for (int j = 0; j < N; j++) {
                b[j] = scanner.nextInt();
            }
            int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
            int flip = 0;
            for (int i = 0; i < N; i++) {
                if (flip == 0) {
                    s1 += a[i];
                    s2 += b[i];
                    flip = 1;
                } else {
                    s3 += a[i];
                    s4 += b[i];
                    flip = 0;
                }
            }
            System.out.println(Math.min(s1 + s4, s2 + s3));
        }
    }
}
