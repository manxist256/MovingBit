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
public class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int FH = N % 2 == 0 ? N / 2 : N /2 + 1;
        int space = FH - 1;
        for (int i = 0; i < FH; i++) {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            space -= 1;
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        space = 0;
        for (int i = 0; i < (N - FH); i++) {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            System.out.print(N % 2 == 0 ? "" : " ");
            space += 1;
            for (int j = 0; j < ((N - FH) - i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
