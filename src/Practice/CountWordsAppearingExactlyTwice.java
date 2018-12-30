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
public class CountWordsAppearingExactlyTwice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] N = new String[sc.nextInt()];
        for (int i = 0; i < N.length; i++) {
            N[i] = sc.next();
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N.length; i++) {
            if (!map.containsKey(N[i])) {
                map.put(N[i], 1);
                continue;
            }
            int ev = map.get(N[i]);
            map.put(N[i], ++ev);
        }
        int ans = 0;
        for (Map.Entry etr : map.entrySet()) {
            if ((int)etr.getValue() == 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
