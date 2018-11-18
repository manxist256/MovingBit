/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class LCMFromGCD {
    
        private static HashSet<Integer> getFactors(int n) {
            HashSet<Integer> factors = new HashSet<>();
            for (int i = 1; i <= (int)Math.sqrt(n); i++) {
                if (n % i == 0) {
                    factors.add(i);
                    factors.add(n/i);
                }
            }
            return factors;
        }
    
    
        private static int GCD(int n1, int n2) {
                HashSet<Integer> f1 = getFactors(n1);
                HashSet<Integer> f2 = getFactors(n2);
                int maxF = 1;
                for (int i : f1) {
                        if (f2.contains(i) && i > maxF) {
                                maxF = i;
                        }
                }
                return maxF;
        }
    
    
        private static int LCM (int... a) {
                int L = 0, n1 = a[0], n2 = a[1];
                int GCD = GCD(n1, n2);
                if (GCD == 1) {
                    System.out.println("values are co-prime");
                }
                n1 /= GCD; 
                return n2 * n1;
        }
     
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), LCM = 0;
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                for (int i = 1; i < N; i++) {
                        if (i == 1) {
                                LCM = LCM (arr[0], arr[1]);
                                continue;
                        }
                        LCM = LCM (LCM, arr[i]);
                }
                System.out.println(LCM);
        }
}
