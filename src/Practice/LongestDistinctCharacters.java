/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class LongestDistinctCharacters {
    
    private static boolean distinctcharacterString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                continue;
            }
            int existingC = map.get(c);
            map.put(c, ++existingC);
        }
        for (Map.Entry etr : map.entrySet()) {
            if ((int)etr.getValue() > 1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); int max = 0;
        for (int i = 0; i < str.length(); i++) {
            String ss = "";
            for (int j = i; j < str.length(); j++) {
                ss = ss + str.charAt(j);
                if (ss.length() > max) {
                    if (distinctcharacterString(ss)) {
                        max = ss.length();
                    }
                }
            }
        }
        System.out.println(max);
    }
}
