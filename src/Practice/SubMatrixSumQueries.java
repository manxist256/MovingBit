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
public class SubMatrixSumQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                sum += arr[i][j];
                arr[i][j] = sum;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                arr[j][i] = arr[j][i] + arr[j - 1][i];
            }
        }
        int xi = sc.nextInt(), xj = sc.nextInt(), yi = sc.nextInt(), yj = sc.nextInt();
        System.out.println(arr[yi][yj] - (xi - 1 >= 0 ? arr[xi - 1][yj] : 0) - (xj - 1 >= 0 ? arr[yi][xj - 1] : 0) + (xi - 1 >= 0 && xj - 1 >= 0 ? arr[xi - 1][xj - 1] : 0));
    }
}
