/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.Lunchtime.December2018;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
class PrintPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int nSq = N * N;
            int[][] result = new int[N][N];
            int i = 1; int si = 0, sj = 0, ei = sj, ej = si;
            if (N == 1) {
                System.out.println(1);
                continue;
            } else if (N == 2) {
                System.out.println("1 2");
                System.out.println("3 4");
                continue;
            }
            while (sj != N) {
                while (sj >= 0) {
                    result[si][sj] = i++;
                    si++; sj--;
                }
                si = ej;
                sj = ei + 1;
                ei = sj;
                ej = si;
               
            }
            si = 1; sj = N - 1; ei = si; ej = sj;
            while (true) {
                while (si != N ) {
                    result[si][sj] = i++;
                    si++; sj--;
                }
                si = ei + 1; sj = ej;
                ei = si; ej = sj;
                if (i == nSq) {
                    break;
                }
            }
            result[N-1][N-1] = i;
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(result[k][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
