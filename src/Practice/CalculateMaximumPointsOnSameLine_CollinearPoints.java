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
public class CalculateMaximumPointsOnSameLine_CollinearPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] xi = new int[N], yi = new int[N];
        for (int i = 0; i < N; i++) {
            xi[i] = sc.nextInt();
            yi[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < xi.length; i++) {
            if (!x.containsKey(xi[i])) {
                x.put(xi[i], 1);
                continue;
            }
            int ev = x.get(xi[i]);
            x.put(xi[i], ++ev);
        }
        HashMap<Integer, Integer> y = new HashMap<>();
        for (int i = 0; i < yi.length; i++) {
            if (!y.containsKey(yi[i])) {
                y.put(yi[i], 1);
                continue;
            }
            int ev = y.get(yi[i]);
            y.put(yi[i], ++ev);
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int cc = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if((xi[j] - xi[i]) == (yi[j] - yi[i])) {
                     cc++;
                }
            }
            if (max < cc + 1) max = cc + 1;
        }
        int maxv = 0;
        for (Map.Entry etr : x.entrySet()) {
            if ((int)etr.getValue() > maxv) {
                maxv = (int)etr.getValue();
            }
        }
        int maxh = 0;
        for (Map.Entry etr : y.entrySet()) {
            if ((int)etr.getValue() > maxh) {
                maxh = (int)etr.getValue();
            }
        }
        System.out.println(Math.max(Math.max(maxv, maxh), max));
    }
}
