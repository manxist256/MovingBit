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
public class NQueens {
    
        private void placeNQueens(char[][] board, int N) {
                this.placeNQueens(board, N, 0, 0);
                this.printQueens(board);
        }
        
        int placed; 
        
        private void printQueens(char[][] board) {
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                                if (board[i][j] == 'Q') System.out.print('Q' + " ");
                                else System.out.print("- ");
                        }
                        System.out.println();
                }
        }
        
        private int getMin(int x, int y) {
                return x > y ? y : x;
        }
        
        private boolean striked(char[][] board, int x, int y, int N) {
                int c = 0;
                // vertical cut
                for (int i = 0; i < N; i++) {
                        if (board[i][y] == 'Q') c++;
                }
                if (c > 1) return true; else c = 0;
                // horizontal cut
                for (int i = 0; i < N; i++) {
                        if (board[x][i] == 'Q') c++;
                }
                if (c > 1) return true; else c = 0;
                // left diagonal cut {max_top->least_bottom}
                int min = getMin(x, y);
                int r_x = x - min, r_y = y - min;
                while (r_x < N && r_y < N) {
                        if (board[r_x][r_y] == 'Q') c++;
                        r_x++; r_y++;
                }
                if (c > 1) return true; else c = 0;
                // right diagonal cut {max_top->least_bottom}
                int min_ = getMin(x, (N - 1) - y);
                int rr_x = x - min_, rr_y = y + min_;
                while (rr_x < N && rr_y >= 0) {
                        if (board[rr_x][rr_y] == 'Q') c++;
                        rr_x++; rr_y--;
                }
                return c > 1;
        }
        
        private void placeNQueens(char[][] board, int N, int x, int y) {
                if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || placed > N) {
                        return;
                }
                for (int i = 0; i < N; i++) {
                        if (placed < N) {
                                board[x][i] = 'Q';
                                placed++;
                                if (!striked(board, x, i, N)) {
                                        placeNQueens(board, N, x + 1, y);
                                } else {
                                        placed--;
                                        board[x][i] = ' ';
                                        continue;
                                }
                        }
                        if (placed < N) {
                                placed--;
                                board[x][i] = ' '; 
                        }
                }
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                new NQueens().placeNQueens(new char[N][N], N);
        }
}
