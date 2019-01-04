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
public class HighestPowerOf2LessThanOrEqualToX {
    
    private static String binary(int N) {
        String binary = "";
        while (N > 1) {
            binary = N % 2 + binary;
            N /= 2;
        }
        return 1 + binary;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String binary = binary(N);
        System.out.println((int)Math.pow(2, binary.length() - 1));
    }
}
