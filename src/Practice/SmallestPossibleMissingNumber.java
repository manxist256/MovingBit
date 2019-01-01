/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author mankank
 */
public class SmallestPossibleMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(A[i]);
        }
        int expected = 1;
        for (int i : set) {
            if (i <= 0) continue;
            if (expected == i) {
                expected++;
            } else {
                System.out.println(expected);
                return;
            }
        }
    }
}
