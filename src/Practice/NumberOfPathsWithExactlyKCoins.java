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
public class NumberOfPathsWithExactlyKCoins {
    
    static int p = 0;
    
    private static void computePath(int[][] arr, int N, int k) {
        computePath(arr, N, k, 0, 0, N - 1, N - 1, 0);
        System.out.println(p);
    }
    
    private static void computePath(int[][] arr, int N, int k, int i, int j, int e1, int e2, int tk) {
        if (i > e1 || j > e2 || tk + arr[i][j] > k) {
            return;
        }
        if (tk + arr[i][j] <= k) {
            if (tk + arr[i][j] == k && i == e1 && j == e2) {
                p++;
                return;
            }
            computePath(arr, N, k, i, j + 1, e1, e2, tk + arr[i][j]);
            computePath(arr, N, k, i + 1, j, e1, e2, tk + arr[i][j]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), k = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        computePath(arr, N, k);
    }
}
