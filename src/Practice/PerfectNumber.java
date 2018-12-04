/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class PerfectNumber {
    
        private static ArrayList<Integer> getFactors(int num) {
                ArrayList<Integer> factors = new ArrayList<>();
                for (int i = 1; i <= Math.sqrt(num); i++) {
                        if (i == 1) {
                                factors.add(i);
                        } else {
                                if (num % i == 0) {
                                        factors.add(i);
                                        if (num / i != i)
                                            factors.add(num / i);
                                }
                        }
                }
                return factors;
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                ArrayList<Integer> f_l;
                for (int i = 6; i < n; i++) {
                        f_l = getFactors(i);
                        int s = 0;
                        for (int l : f_l) {
                                s += l;
                        }
                        if (s == i)
                                System.out.println(i);
                }
        }
}
