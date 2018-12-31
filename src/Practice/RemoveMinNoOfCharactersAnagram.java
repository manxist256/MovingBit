package Practice;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mankank
 */
public class RemoveMinNoOfCharactersAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1  = sc.nextLine();
        String s2 = sc.nextLine();
        int[] s1c = new int[26], s2c = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            s2c[s2.charAt(i) - 97]++;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s1c[c - 97] < s2c[c - 97]) {
                System.out.print(s1.charAt(i));
                s1c[c - 97]++;
            }
        }
    }
}
