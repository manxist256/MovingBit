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
public class NextSparseBinaryNumber {
    
    private static boolean isSparse(int N) {
        String binary = "";
        while (N > 1) {
            binary = N % 2 + binary;
            N /= 2;
        }
        binary = 1 + binary;
        System.out.println(binary + " " + N);
        for (int i = 0; i < binary.length() - 1; i++) {
            if (binary.charAt(i) == binary.charAt(i + 1) && binary.charAt(i) == 49) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1;
        while (!isSparse(N)) {
            N += 1;
        }
        System.out.println(N);
    }
}
