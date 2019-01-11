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
//Merge sort logic and 'inter-search max sum' between each merges.
public class MaximumSumPathInTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] a1 = new int[N], a2 = new int[M];
        for (int i = 0; i < N; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            a2[i] = sc.nextInt();
        }
        int i = 0, j = 0, sum1 = 0, sum2 = 0, res = 0;
        while (i < N && j < M) {
            if (a1[i] < a2[j]) {
                sum1 += a1[i];
                i += 1;
            } else if (a1[i] > a2[j]) {
                sum2 += a2[j];
                j += 1;
            } else { //a1[i] == a2[j]
                res += (sum1 > sum2 ? sum1 : sum2) + a1[i];
                sum1 = 0; sum2 = 0;
                i += 1; j += 1;
            }
        }
        while (i < N) {
            sum1 += a1[i++];
        }
        while (j  < M) {
            sum2 += a2[j++];
        }
        res += (sum1 > sum2 ? sum1 : sum2);
        System.out.println(res);
    }
}
