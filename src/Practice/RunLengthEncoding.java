/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class RunLengthEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
                continue;
            }
            int ev = map.get(s.charAt(i));
            map.put(s.charAt(i), ++ev);
        }
        for (Map.Entry etr : map.entrySet()) {
            System.out.print(etr.getKey()+""+etr.getValue());
        }
    }
}
