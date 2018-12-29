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
public class StringObtainedByRotatingAnotherString2Places {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder b1 = new StringBuilder(sc.nextLine());
        StringBuilder b2 = new StringBuilder(b1.toString());
        StringBuilder b3 = new StringBuilder(sc.nextLine());
        char c1 = b1.charAt(0); char c2 = b1.charAt(1);
        char c3 = b1.charAt(b1.length() - 1); char c4 = b1.charAt(b1.length() - 2);
        b1.deleteCharAt(0); b1.deleteCharAt(0); b1.append(c1); b1.append(c2); 
        b2.deleteCharAt(b2.length() - 1); b2.deleteCharAt(b2.length() - 1);
        if (b1.toString().equals(b3.toString()) || (c4 + "" + c3 + b2.toString()).equals(b3.toString())) {
            System.out.println("YES");
        }
    }
}
