/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cryptography;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Polyalphabetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(), key = sc.nextLine(), formkey = "", cipher = "", plain = "";
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            formkey += key.charAt(k);
            k++;
            if (k == key.length()) {
                k = 0;
            }
        }
        int[] wm = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            wm[i] = (str.charAt(i) - 97) + (formkey.charAt(i) - 97);
            cipher += (char)(97 + (wm[i] % 26));
        }
        System.out.println(cipher);
        for (int i = 0; i < str.length(); i++) {
            plain += (char)(97 + (wm[i] - (formkey.charAt(i) - 97)));
        }
        System.out.println(plain);
    }
}
    