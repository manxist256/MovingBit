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
public class TwoNonRepeatingElementsInAArrayOfRepeatingElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                continue;
            }
            int ev = map.get(arr[i]);
            map.put(arr[i], ++ev);
        }
        for (Map.Entry etr : map.entrySet()) {
            if ((int)etr.getValue() == 1) {
                System.out.print((int)etr.getKey() + " ");
            }
        }
    }
}
