/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Fibonacci {
    private static long fibo(int n, long[] memoize) {
        if (memoize[n - 1] != -1) {
            return memoize[n - 1];
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        long fibo = fibo(n - 1, memoize) + fibo(n - 2, memoize);
        memoize[n - 1] = fibo;
        return fibo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] memoize = new long[n];
        Arrays.fill(memoize, -1);
        System.out.println(fibo(n, memoize));
    }
}
