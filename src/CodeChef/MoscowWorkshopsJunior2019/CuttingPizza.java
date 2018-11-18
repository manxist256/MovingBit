
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.MoscowWorkshopsJunior2019;

/**
 *
 * @author mankank
 */
class CuttingPizza {
    
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] slice = new int[n];
            for (int i = 0; i < n; i++) {
                slice[i] = sc.nextInt();
            }
            Arrays.sort(slice);
            int[] p = new int[n];
            p[p.length - 1] = (slice[0] + 360) - slice[slice.length - 1];
            for (int i = slice.length - 2; i >= 0; i--) {
                p[i] = slice[i + 1] - slice[i];
            }
            int gcd = 1;
            for (int i = 1; i < p.length; i++) {
                if (i == 1) {
                    gcd = GCD(p[0], p[1]);
                    continue;
                }
                gcd = GCD(gcd, p[i]);
            }
            System.out.println((360 / gcd) - slice.length);
        }
    }
}
