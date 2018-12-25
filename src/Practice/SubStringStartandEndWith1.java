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
public class SubStringStartandEndWith1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            String ss = "";
            if (s.charAt(i) == '0') continue;
            for (int j = i; j < s.length(); j++) {
                ss = ss + s.charAt(j);
                if (i == j) continue;
                if (s.charAt(j) == '1') {
                    System.out.print(ss + " ");
                }
            }
        }
    }
}
