/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        Arrays.fill(arr, 1);
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;
            for (int j = 2; i * j <= N; j++) {
                arr[i * j] = 0;
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] == 1 ? i + " " : "");
        }
    }
}
