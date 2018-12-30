/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class CheckIfANumberCanBeExpressedAsXPowY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                factors.add(N/i);
                factors.add(i);
            }
        }
        outer : for (int i = (int)Math.sqrt(N); i >= 2; i--) {
            int k = N; int c = 0;
            while (k > 1) {
                if (k % i == 0 && factors.contains(k / i)) {
                    k /= i;
                    c++;
                } else {
                    continue outer;
                }
            }
            if (k == 1) {
                System.out.println(i + " " + c);
                break;
            }
        }
    }
}
