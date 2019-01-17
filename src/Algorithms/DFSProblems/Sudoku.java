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
/*
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0 
0 8 7 0 0 0 0 3 1 
0 0 3 0 1 0 0 8 0 
9 0 0 8 6 3 0 0 5 
0 5 0 0 9 0 6 0 0 
1 3 0 0 0 0 2 5 0 
0 0 0 0 0 0 0 7 4 
0 0 5 2 0 6 3 0 0*/
//https://www.geeksforgeeks.org/sudoku-backtracking-7/
public class Sudoku {
    
    static int tbf;
    
    private static boolean nh(int k, int[][] sudoku, int i, int j) {
        for (int c = 0; c < 9; c++) {
            if (sudoku[i][c] == k) {
                return false;
            }
        }
        for (int r = 0; r < 9; r++) {
            if (sudoku[r][j] == k) {
                return false;
            }
        }
        int rk = i - (i % 3), ck = j - (j % 3);
        for (int l = rk; l < (rk + 3); l++) {
            for (int p = ck; p < (ck + 3); p++) {
                if (sudoku[l][p] == k) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void buildsudoku(int[][] sudoku, int[][] pf, int c, int i, int j) {
        if (i > 8 || j > 8 || tbf == c) { // board limit is crossed.
            return;
        }
        if (pf[i][j] != -1) { //position already filled in sudoku
            if (j < 8) {
                buildsudoku(sudoku, pf, c, i, ++j);
            } else {
                buildsudoku(sudoku, pf, c, ++i, 0);
            }
            return;
        }
        for (int k = 1; k <= 9; k++) {
            if (nh(k, sudoku, i, j)) {
                tbf++;
                sudoku[i][j] = k;
                if (j < 8) {
                    buildsudoku(sudoku, pf, c, i, ++j);
                    if (tbf == c) {
                        break;
                    } else {
                        tbf--;
                        j -= 1;
                        sudoku[i][j] = 0;
                    }
                } else {
                    buildsudoku(sudoku, pf, c, ++i, 0);
                    if (tbf == c) {
                        break;
                    } else {
                        tbf--;
                        i -= 1;
                        sudoku[i][j] = 0;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        int[][] pf = new int[9][9];
        int c = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
                if (sudoku[i][j] == 0)  { pf[i][j] = -1; c++; }
            }
        }
        
        buildsudoku(sudoku, pf, c,  0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
