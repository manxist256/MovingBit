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
public class FindAPeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    System.out.println(arr[i]);
                    break;
                }
            } else if (i == N - 1) {
                if (arr[i] > arr[i - 1]) {
                    System.out.println(arr[i]);
                    break;
                }
            } else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.println(arr[i]);
                    break;
                }
            }
        }
    }
}
