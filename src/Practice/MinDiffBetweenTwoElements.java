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
public class MinDiffBetweenTwoElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] - arr[i] <  min) {
                min = arr[i + 1] - arr[i];
            }
        }
        System.out.println(min);
    }
}
