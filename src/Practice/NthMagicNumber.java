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
public class NthMagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0, k = 0;
        while (true) {
            i += 1;
            k += i;
            if (n <= k) {
                int s = (k - i) + 1, l = 0;
                int g = (int)Math.pow(5, i);
                if (s == n) {
                    System.out.println(g);
                    return;
                } else {
                    System.out.println(g + (int)Math.pow(5, n-s));
                    return;
                }
            }
        }
    }
}
