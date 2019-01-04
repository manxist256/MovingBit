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
public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int half = N / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int e = sc.nextInt();
            if (!map.containsKey(e)) {
                map.put(e, 1);
                continue;
            }
            int ev = map.get(e);
            map.put(e, ++ev);
        }
        for (Map.Entry<Integer, Integer> etr : map.entrySet()) {
            if (etr.getValue() > half) {
                System.out.println(etr.getKey());
                break;
            }
        }
    }
}
