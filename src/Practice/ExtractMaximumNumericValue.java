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
public class ExtractMaximumNumericValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String t = ""; int max = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c - 48 >= 0 && c - 48 <= 9) {
                t = t + c;
            }
            if (i == string.length() - 1 && !t.equals("") || 
                    (!t.equals("") && !(c - 48 >= 0 && c - 48 <= 9))) {
                if (Integer.parseInt(t) > max) {
                    max = Integer.parseInt(t);
                }
                t = "";
            }
        }
        System.out.println(max);
    }
}
