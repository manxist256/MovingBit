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
public class BinaryPrinting {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int max = (int)Math.pow(2, N);
                for (int i = 0; i < max; i++) {
                        for (int j = N - 1; j >= 0; j--) {
                                if ((i & (1 << j)) > 0) {
                                        System.out.print(1 + " ");
                                } else {
                                    System.out.print(0 + " ");
                                }
                        }
                        System.out.println();
                }
        }
}
