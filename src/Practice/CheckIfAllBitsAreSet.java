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
public class CheckIfAllBitsAreSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] twoPowNMinus1 = new int[32];
        for (int i = 0; i < twoPowNMinus1.length; i++) {
            twoPowNMinus1[i] = (int)Math.pow(2, i) - 1;
        }
        int N = sc.nextInt();
        for (int i = 0; i < twoPowNMinus1.length; i++) {
            if (N == twoPowNMinus1[i]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
