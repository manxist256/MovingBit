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
public class MaximumSumOfIxArr_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0, cs = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (i > 0) sum += arr[i];
            cs = cs + (arr[i] * i);
        }
        int max = cs;
        for (int i = 1; i < N; i++) {
            cs = (arr[i - 1] * (N - 1)) + (cs - sum);
            sum -= arr[i];
            sum += arr[i - 1];
            if (cs > max) max = cs;
        }
        System.out.println(max);
    }
}
