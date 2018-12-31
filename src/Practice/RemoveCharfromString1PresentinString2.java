/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class RemoveCharfromString1PresentinString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String mask = sc.nextLine();
        HashSet<Character> set = new HashSet<>(); 
        for (int i = 0; i < mask.length(); i++) {
            set.add(mask.charAt(i));
        }
        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(s1.charAt(i))) {
                continue;
            } 
            System.out.print(s1.charAt(i));
        }
    }
}
