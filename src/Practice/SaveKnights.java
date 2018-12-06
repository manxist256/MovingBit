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
public class SaveKnights {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                if (N % 2 == 0) {
                        System.out.println("Max Knights : " + ((N * N) / 2));
                } else if (N % 2 != 0) {
                        System.out.println("Max Knights : " + ((((N + 1) / 2) * ((N + 1) / 2)) + ((N / 2) * (N / 2))));
                }
                char board[][] = new char[N][N]; int flag = 0;
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                                if (flag == 0 && j % 2 == 0) {
                                        board[i][j] = 'K';
                                } else if (flag == 1 && j % 2 != 0) {
                                        board[i][j] = 'K';
                                }
                        }
                        flag = flag == 0 ? 1 : 0;
                }
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0 ; j < board.length; j++) {
                                System.out.print(board[i][j] + " ");
                        }
                        System.out.println();
                }
        }
}
