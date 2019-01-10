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
public class SubArrayWGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), sum = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int ptr = 0, c = 0;
        for (int i = 0; i < arr.length; i++) {
            c += arr[i];
            if (c > sum) {
                while (c > sum) {
                    c -= arr[ptr++];
                }
            }
            if (c == sum) {
                System.out.println(i);
                System.out.println("SubArray found");
                break;
            }
        }
    }
}
