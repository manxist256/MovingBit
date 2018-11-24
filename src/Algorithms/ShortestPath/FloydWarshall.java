/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.ShortestPath;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
//ASSP
public class FloydWarshall {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int adj_mat[][]  = new int[N][N];
                for(int i = 0; i < N; i++) {
                        for(int j = 0 ;j < N; j++)
                                adj_mat[i][j]=sc.nextInt();
                }
                for(int k = 0; k < N; k++) {
                        for(int i = 0;i < N; i++){
                                for(int j = 0; j < N; j++){
                                    if(adj_mat[i][j] > adj_mat[i][k] + adj_mat[k][j])
                                        adj_mat[i][j] = adj_mat[i][k] + adj_mat[k][j];
                                }
                        }
                }
                for(int i = 0; i < N; i++) {
                        for(int j = 0; j < N; j++){
                                System.out.print(adj_mat[i][j]+" ");
                        }
                        System.out.println();
                }
        }
}
