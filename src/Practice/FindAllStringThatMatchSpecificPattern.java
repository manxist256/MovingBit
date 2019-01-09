/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class FindAllStringThatMatchSpecificPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextLine();
        }
        String pattern = sc.nextLine();
        outer : for (int i = 0; i < array.length; i++) {
            String s = array[i];
            HashMap<Character, Character> pm = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < pattern.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    pm.put(pattern.charAt(j), s.charAt(j));
                }
            }
            for (int j = 0; j < pattern.length(); j++) {
                int c = s.charAt(j);
                if (!pm.containsKey(pattern.charAt(j)) || pm.get(pattern.charAt(j)) != c) {
                    continue outer;
                }
            }
            System.out.println(s);
        }
    }
}
