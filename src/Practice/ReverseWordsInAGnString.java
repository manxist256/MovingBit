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
public class ReverseWordsInAGnString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int space = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                space++;
            }
        }
        String array[] = new String[space + 1];
        String temp = ""; int ptr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                array[ptr++] = temp;
                temp = "";
                continue;
            }
            if (i == s.length() - 1) {
                temp = temp + s.charAt(i);
                array[ptr++] = temp;
                continue;
            }
            temp = temp + s.charAt(i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
