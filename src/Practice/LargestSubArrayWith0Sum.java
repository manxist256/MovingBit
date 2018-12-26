/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class LargestSubArrayWith0Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int k1 = 0, k2 = 0;
        for (int i = 0; i < N; i++) {
            int s = 0;
            for (int j = i; j < N; j++) {
                s += arr[j];
                if (s == 0) {
                    if (j - (i - 1) > (k2 - k1) - 1) {
                        k1 = i;
                        k2 = j;
                    }
                }
            }
        }
        System.out.println(k1 + " " + k2);
    }
}
