/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.PatternMatching;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class NaivePatternMatchingAlgortihm {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                String pattern  = sc.nextLine();
                for (int i = 0; i < ((s.length() - pattern.length()) + 1); i++) {
                        String c = "";
                        for (int j = i; j < pattern.length() + i; j++) {
                                c += s.charAt(j);
                        }
                        if (pattern.equals(c)) {
                                System.out.println("Pattern exists");
                                return;
                        }
                }
                System.out.println("Pattern not exists");
        }
}
