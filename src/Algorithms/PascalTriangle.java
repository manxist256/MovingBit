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
public class PascalTriangle {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt(), space = n - 1;
                int[] pa = {1};
                for (int i = 0; i < space; i++) {
                        System.out.print(" ");
                }
                System.out.println(pa[0]);
                space -= 1;
                for (int i = 2; i <= n; i++) {
                        int[] na = new int[i];
                        na[0] = 1; na[na.length - 1] = 1;
                        for (int j = 0; j < space; j++) {
                                System.out.print(" ");
                        }
                        for (int j = 1; j < na.length - 1; j++) {
                                na[j] = pa[j] + pa[j - 1];
                        }
                        for (int j = 0; j < na.length; j++) {
                                System.out.print(na[j] + " ");
                        }
                        System.out.println();
                        pa = na;
                        space -= 1;
                }
        }
}
