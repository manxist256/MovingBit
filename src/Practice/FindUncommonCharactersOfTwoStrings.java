/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class FindUncommonCharactersOfTwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }
        ArrayList<Character> answer = new ArrayList<>();
        for (char c : set1) {
            if (!set2.contains(c)) {
                answer.add(c);
            }
        }
        for (char c : set2) {
            if (!set1.contains(c)) {
                answer.add(c);
            }
        }
        Collections.sort(answer);
        System.out.println(answer);
    }
}
