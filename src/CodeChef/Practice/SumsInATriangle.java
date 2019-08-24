package CodeChef.Practice;

import java.util.Scanner;

public class SumsInATriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[][] triangle = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }
            for (int i = N - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
                }
            }
            System.out.println(triangle[0][0]);
        }
    }
}
