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

class Pair {
    int i1, i2;
    public Pair (int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }
}

public class FourElementsSumofTwoEqualsSumOfOtherTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        LinkedHashMap<Pair, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                map.put(new Pair(i, j), A[i] + A[j]);
            }
        }
        for (Map.Entry outer : map.entrySet()) {
            Pair op = (Pair)outer.getKey();
            int sum = (int)outer.getValue();
            for (Map.Entry inner : map.entrySet()) {
                Pair ip = (Pair)inner.getKey();
                if (ip.equals(op)) {
                    continue;
                }
                if (sum == (int)inner.getValue()) {
                    if (op.i1 != ip.i1 && op.i1 != ip.i2 && op.i2 != ip.i1 && op.i2 != ip.i2) {
                        System.out.println(A[op.i1] + " " + A[op.i2] + " " + A[ip.i1] + " " + A[ip.i2]);
                        return;
                    }
                }
            }
        }
    }
}
