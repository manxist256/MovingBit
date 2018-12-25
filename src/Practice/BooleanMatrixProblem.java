/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class BooleanMatrixProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] arr = new int[N][M];
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i : rows) {
            for (int k = 0; k < M; k++) {
                arr[i][k] = 1;
            }
        }
        for (int i : cols) {
            for (int k = 0; k < N; k++) {
                arr[k][i] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
