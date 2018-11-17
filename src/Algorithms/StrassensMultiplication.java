/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class StrassensMultiplication {
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int A[][] = new int[N][N], B[][] = new int[N][N];
                int result[][] = new int[N][N];
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                                A[i][j] = sc.nextInt();
                        }
                }
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                                B[i][j] = sc.nextInt();
                        }
                }
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                                for (int k = 0; k < N; k++) {
                                        result[i][j] += (A[i][k]*B[k][j]);
                                }
                        }
                }
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                                System.out.print(result[i][j] + " ");
                        }
                        System.out.println("");
                }
        }
        
}
