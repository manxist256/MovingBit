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
public class GivenTwoUnsortedArraysFindAllPairsOfX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), X = sc.nextInt();
        int[] a1 = new int[N], a2 = new int[M];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a2.length; i++) {
            a2[i] = sc.nextInt();
            if (!map.containsKey(a2[i])) {
                map.put(a2[i], 1);
                continue;
            }
            int ev = map.get(a2[i]);
            map.put(a2[i], ++ev);
        }
        for (int i = 0; i < a1.length; i++) {
            int req = X - a1[i];
            if (!map.containsKey(req)) {
                continue;
            }
            int count = map.get(req);
            for (int j = 0; j < count; j++) {
                System.out.println(a1[i] + " " + req);
            }
        }
    }
}
