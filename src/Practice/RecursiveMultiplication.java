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
public class RecursiveMultiplication {
    
    private static int recursiveMultiply(int N, int M) {
        if (M == 1) {
            return N;
        } 
        int re = recursiveMultiply(N, --M);
        return re + N;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        System.out.println(recursiveMultiply(N, M));
    }
}
