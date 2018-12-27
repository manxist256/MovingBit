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
public class RowWithMax1s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int row = -1, max = 0;
        for (int i = 0; i < N; i++) {
            int oc = 0;
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    oc++;
                }
            }
            if (oc > max) {
                max = oc;
                row = i;
            }
        }
        System.out.println("row = " + row + " with " + max + " 1's");
    }
}
