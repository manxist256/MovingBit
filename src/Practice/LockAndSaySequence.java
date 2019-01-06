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
public class LockAndSaySequence {
    
    private static String findlockandsay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String rv = findlockandsay(n - 1);
        String nv = "";
        int c = 0;
        // parse logic
        for (int i = 0; i < rv.length() - 1; i++) {
            if (rv.charAt(i) == rv.charAt(i + 1)) {
                c++;
                if (i == rv.length() - 2) {
                    nv = nv + (c + 1) + (rv.charAt(i) - 48);
                }
            } else {
                c += 1;
                nv = nv + c + (rv.charAt(i) - 48);
                c = 0;
                if (i == rv.length() - 2) {
                    nv = nv + 1 + (rv.charAt(i + 1) - 48);
                }
            }
        }
        return nv;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findlockandsay(n));
    }
}
