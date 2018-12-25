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
public class BinaryPrinting {
    
    private static int twoPowLogN(int n) {
        int i = 1;
        while (true) {
            if (n < Math.pow(2, i++)) {
                return i - 1;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), twoPow = twoPowLogN(N);
        for (int i = 0; i <= N; i++) {
            for (int j = twoPow - 1; j >= 0; j--) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
