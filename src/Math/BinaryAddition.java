/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class BinaryAddition {
    
   private static String getModifiedS(String s, int diff) {
       for (int i = 0; i < diff; i++) {
           s = "0" + s;
       }
       return s;
   }
    
    private static void binaryAddition(String b1, String b2) {
        if (b1.length() < b2.length()) {
            b1 = getModifiedS(b1, b2.length() - b1.length());
        } else if (b2.length() < b1.length()) {
            b2 = getModifiedS(b2, b1.length() - b2.length());
        }
        String res = "";
        int l = b1.length(), c = 0;
        for (int i = l - 1; i >= 0; i--) {
            int a = b1.charAt(i) - 48, b = b2.charAt(i) - 48;
            if (a == 0 && b == 0) {
                if (c == 0) {
                    res =  "0" + res;
                }
                else if (c == 1) {
                    res = "1" + res;
                    c = 0;
                }
            } else if ((a == 1 && b == 0) || (a == 0 && b == 1)) {
                if (c == 0) {
                    res =  "1" + res;
                } else if (c == 1) {
                    res =  "0" + res;
                }
            } else if (a == 1 && b == 1) {
                if (c == 0) {
                    res = "0" + res;
                    c = 1;
                } else if (c == 1) {
                    res = "1" + res;
                }
            }
        }
        if (1 == c) {
            res = c + res;
        }
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b1 = sc.nextLine();
        String b2 = sc.nextLine();
        binaryAddition(b1, b2);
    }
}
