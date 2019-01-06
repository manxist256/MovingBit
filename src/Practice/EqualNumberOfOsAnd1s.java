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
public class EqualNumberOfOsAnd1s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] diff = new int[N];
        int zc = 0, oc = 0;
        HashMap<Integer, Integer> f = new HashMap<>();
        HashMap<Integer, Integer> l = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                zc++;
            } else {
                oc++;
            }
            diff[i] = zc - oc;
            if (!f.containsKey(diff[i])) f.put(diff[i], i);
            l.put(diff[i], i);
        }
        int max = 0;
        int i = 0, j = 0;
        for (Map.Entry<Integer, Integer> etr : f.entrySet()) {
            int first = etr.getValue(); 
            int last = l.get(etr.getKey());
            if (last - first > max) {
                max = last - first;
                i = first + 1; 
                j = last;
            }
        }
        System.out.println(i + " " + j);
    }
}
