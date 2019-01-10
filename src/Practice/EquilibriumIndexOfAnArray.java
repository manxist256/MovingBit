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
public class EquilibriumIndexOfAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ls = new int[N], rs = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            ls[i] = sum;
        }
        sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += arr[i];
            rs[i] = sum;
        }
        for (int i = 0; i < N; i++) {
            int v = arr[i];
            if (ls[i] - v == rs[i] - v) {
                System.out.println("Equilibrium index : " + i + " " + (ls[i] - v));
                return;
            }
        }
        System.out.println(-1);
    }
}
