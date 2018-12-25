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
public class BitDifferenceAtoB {
    
    private static String binary(int n) {
        String binary = "";
        while (n != 1) {
            binary = n % 2 + binary;
            n /= 2;
        }
        binary = 1 + binary;
        return binary;
    }
    
    private static String mitigateStringLength(String s, int lead) {
        for (int i = 0; i < lead; i++) {
            s = 0 + s;
        }
        return s;
    }
    
    private static void findBitDifference(String s1, String s2) {
        if (s1.length() < s2.length()) {
            s1 = mitigateStringLength(s1, s2.length() - s1.length());
        } else if (s2.length() < s1.length()) {
            s2 = mitigateStringLength(s2, s1.length() - s2.length());
        }
        System.out.println(s1);
        System.out.println(s2);
        int ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt();
        String bn1 = binary(n1);
        String bn2 = binary(n2);
        findBitDifference(bn1, bn2);
    }
}
