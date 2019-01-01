/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class PrintAllPossibleWords {
    
    private static void prefillmap(HashMap<Integer, String> map) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
    
    private static void recursion(HashMap<Integer, String> map, String s, int pos, String j) {
        if (pos == s.length()) {
            System.out.println(j);
            return;
        }
        String itr = map.get(s.charAt(pos) - 48);
        for (int i = 0; i < itr.length(); i++) {
            recursion(map, s, pos + 1, j + itr.charAt(i));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Integer, String> map = new HashMap<>();
        prefillmap(map);
        recursion(map, s, 0, "");
    }
}
