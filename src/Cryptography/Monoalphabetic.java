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
public class Monoalphabetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(), key = sc.nextLine(), cipher = "", plain = "";
        char[] key_array = new char[26];
        for (int i = 0; i < key.length(); i++) {
            key_array[i] = key.charAt(i);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cipher += (key_array[c - 97]);
        }
        System.out.println(cipher);
        for (int i = 0; i < cipher.length(); i++) { // don't make TC: O(n*26) to decrypt. Maintain a hashMap and perform decrypt in O(n);
            int c = cipher.charAt(i);
            for (int j = 0; j < key_array.length; j++) {
                if (c == key_array[j]) {
                    plain += (char)(97 + j);
                    break;
                }
            }
        }
        System.out.println(plain);
    }
}
