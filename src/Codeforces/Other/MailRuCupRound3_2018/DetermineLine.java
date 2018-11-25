/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Other.MailRuCupRound3_2018;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class DetermineLine {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] arr = new int[101];
                for (int k = 0; k < N; k++) {
                        int r = sc.nextInt();
                        for (int i = 0; i < r; i++) {
                                int a = sc.nextInt();
                                arr[a]++;
                        }
                }
                for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == N) {
                                System.out.print(i + " ");
                        }
                }
        }
}
