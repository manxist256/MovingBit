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
public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] n1 = new int[N], n2 = new int[M];
        int i = N - 1, j = M - 1, C = 0;
        String result = "";
        for (int a = 0; a < N; a++) {
            n1[a] = sc.nextInt();
        }
        for (int a = 0; a < M; a++) {
            n2[a] = sc.nextInt();
        }
        while (i >= 0 && j >= 0) {
            int add = n1[i] + n2[j] + C;
            if (add > 9) {
                C = 1;
            } else {
                C = 0;
            }
            result = (add % 10) + result;
            if (i == 0 && j == 0 && C == 1) result = C + result;
            i--; j--;
        }
        while (i >= 0) {
            int add = n1[i] + C;
            if (add > 9) {
                C = 1;
            } else {
                C = 0;
            }
            result = (add % 10) + result;
            if (i == 0 && C == 1) result = C + result;
            i--;
        }
        while (j >= 0) {
            int add = n2[j] + C;
            if (add > 9) {
                C = 1;
            } else {
                C = 0;
            }
            result = (add % 10) + result;
            if (j == 0 && C == 1) result = C + result;
            j--;
        }
        System.out.println(result);
    }
}
