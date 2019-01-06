/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class SpiralMatrixKthElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int s1 = 0, s2 = 0;
        int s3 = 0, s4 = M - 1;
        int s5 = N - 1, s6 = M - 1;
        int s7 = N - 1, s8 = 0; int cntr = 0;
        int k = sc.nextInt();
        outer : while (cntr < (N * M)) {
            for (int i = s2; i <= s4; i++) {
                cntr++;
                if (cntr == k) {
                    System.out.print(array[s1][i] + " ");
                    break outer;
                }
            }
            for (int i = s3 + 1; i <= s5; i++) {
                cntr++;
                if (cntr == k) {
                    System.out.print(array[i][s4] + " ");
                    break outer;
                }
            }
            s3 += 1;  s4 -= 1;
            for (int i = s6 - 1; i >= s8; i--) {
                cntr++;
                if (cntr == k) {
                    System.out.print(array[s5][i] + " ");
                    break outer;
                }
            }
            s5 -= 1; s6 -= 1;
            for (int i = s7 - 1; i >= s1 + 1; i--) {
                cntr++;
                if (cntr == k) { 
                    System.out.print(array[i][s8] + " ");
                    break outer;
                }
            }
            s7 -= 1; s8 += 1;
            s1 += 1; s2 += 1;
        }
    }
}
