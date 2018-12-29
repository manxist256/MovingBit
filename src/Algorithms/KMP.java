/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class KMP {
    
    private static int[] getlps(String pattern) {
        int i = 1, j = 0, k = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        outer : while (k < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[k] = j + 1;
                j++;
            } else {
                if (j == 0) {
                    lps[k] = 0;
                } else {
                    //find next j position.
                    while (j > 0) {
                        j = lps[j - 1];
                        if (pattern.charAt(j) == pattern.charAt(i)) {
                            continue outer;
                        }
                    }
                    j = 0;
                    continue;
                }
            }
            k++; i++;
        }
        return lps;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        int[] lps = getlps(pattern);
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            //System.out.println(k);
            if (text.charAt(i) == pattern.charAt(k)) {
                k++;
            } else {
                if (k > 0) {
                    k = lps[k - 1];
                    i--;
                }
            }
            if (k == pattern.length()) {
                System.out.println("pattern exists");
                return;
            }
        }
        System.out.println("pattern not exists");
    }
}
