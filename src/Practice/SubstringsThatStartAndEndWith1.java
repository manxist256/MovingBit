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
public class SubstringsThatStartAndEndWith1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int noc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 48 == 1) {
                noc++;
            }
        }
        System.out.println((noc * (noc - 1)) / 2);
    }
}
