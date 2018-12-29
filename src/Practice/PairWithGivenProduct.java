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
public class PairWithGivenProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] array = new double[N];
        HashMap<Double, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1.0);
                continue;
            } 
            map.put(array[i], 1 + map.get(array[i]));
        }
        int x = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            double div = x / array[i];
            if ((array[i] == div && map.get(array[i]) > 1) || map.containsKey(div)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
