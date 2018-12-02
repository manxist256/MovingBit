/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DFSProblems;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
// Backtracking
public class KnightsTour {
    
        private final int xi[]={2, 1, -1, -2, -2, -1, 1, 2};
        private final int yi[]={1, 2, 2, 1, -1, -2, -2, -1};
    
        private void getKnightsTour(int[][] board, int N) {
                buildKnightsTour(board, 0, 0, N);
                printBoard(board);
        }
        
        private void printBoard(int[][] board) {
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                                System.out.print(board[i][j] + "    ");
                        }
                        System.out.println();
                }
        }
        
        int tour = 1;
        
        private void buildKnightsTour(int[][] board, int x, int y, int N) {
                if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || tour > (N * N) || board[x][y] > 0) {
                        return;
                }
                board[x][y] = tour++;
                for (int i = 0; i < 8; i++) {
                        buildKnightsTour(board, x + xi[i], y + yi[i], N);
                }
                if (tour != (N * N) + 1) {
                        tour--;
                        board[x][y] = 0;
                }
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                new KnightsTour().getKnightsTour(new int[N][N], N);
        }
}
    