/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class MinDiffPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if (diff < min) {
                min = diff;
            }
        }
        System.out.println(min);
    }
}
