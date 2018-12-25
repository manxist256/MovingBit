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
public class AdditionOfSubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int S1 = sc.nextInt(), S2 = sc.nextInt();
        int E1 = sc.nextInt(), E2 = sc.nextInt();
        int sum = 0;
        for (int i = S1; i <= E1; i++) {
            for (int j = S2; j <= E2; j++) {
                sum += array[i][j];
            }
        }
        System.out.println(sum);
    }
}
