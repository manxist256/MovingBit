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
public class CaesarCipher {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine(), ciphertext = "", plaintext="";
                int key = sc.nextInt();
                key %= 26;
                for (int i = 0; i < str.length(); i++) {
                    int k = key; char c = str.charAt(i);
                    if ('z' - c < k) {
                        k -= ('z' - c);
                        ciphertext += (char)(96 + k);
                    }
                    else {
                        ciphertext += (char)(c + k);
                    }
                }
                System.out.println(ciphertext);
                for (int i = 0; i < ciphertext.length(); i++) {
                    int k = key; char c = ciphertext.charAt(i);
                    if (c - 'a' < k) {
                        k -= (c - 'a');
                        plaintext += (char)(122 - (k - 1));
                    } else {
                        plaintext += (char)(c - k);
                    }
                }
                System.out.println(plaintext);
        }
}
