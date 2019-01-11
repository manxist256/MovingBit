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
public class FindAnEqualPointInAStringOfBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] o = new int[s.length()];
        int[] c = new int[s.length()];
        int oc = 0, cc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') oc++;
            o[i] = oc;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') cc++;
            c[i] = cc;
        }
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == o[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(s.length());
    }
}
