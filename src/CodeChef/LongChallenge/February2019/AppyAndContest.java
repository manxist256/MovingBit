/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.February2019;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
class AppyAndContest {
    
    private static HashSet<Long> getFactors(long n) {
            HashSet<Long> factors = new HashSet<>();
            for (long i = 1; i <= (long)Math.sqrt(n); i++) {
                if (n % i == 0) {
                    factors.add(i);
                    factors.add(n/i);
                }
            }
            return factors;
        }
    
    
        private static long GCD(long n1, long n2) {
                HashSet<Long> f1 = getFactors(n1);
                HashSet<Long> f2 = getFactors(n2);
                long maxF = 1;
                for (long i : f1) {
                        if (f2.contains(i) && i > maxF) {
                                maxF = i;
                        }
                }
                return maxF;
        }
    
    
        private static long LCM (long... a) {
                long L = 0, n1 = a[0], n2 = a[1];
                long GCD = GCD(n1, n2);
                if (GCD == 1) {
                    //System.out.println("values are co-prime");
                }
                n1 /= GCD; 
                return n2 * n1;
        }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        while (T-- > 0) {
            long N = sc.nextLong(), A = sc.nextLong(), B = sc.nextLong(), K = sc.nextLong();
            long aS = N / A, bS = N / B, both = N / (LCM(A, B));
            //as = 3 bs = 2 b = 1
            if ((aS + bS) - (2 * both) >= K) {
                System.out.println("Win");
            } else {
                System.out.println("Lose");
            }
        }
    }
}
