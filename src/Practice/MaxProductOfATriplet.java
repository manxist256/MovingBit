/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class MaxProductOfATriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                list.add(A[i] * A[j]);
            }
        }
        //System.out.println(list);
        int c = A.length - 2, k = c, max = -Integer.MAX_VALUE;
        for (int i : list) {
            for (int j = A.length - c; j < A.length; j++) {
                if (i * A[j] > max) {
                    max = i * A[j];
                }
            }
            c -= 1;
            if (c == 0) {
                c = k - 1;
                k = c;
            }
        }
        System.out.println(max);
    }
}
