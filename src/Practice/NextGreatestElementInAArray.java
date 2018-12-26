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
public class NextGreatestElementInAArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE, v = -1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i] < arr[j] && arr[j] - arr[i] < min) {
                    min = arr[j] - arr[i];
                    v = arr[j];
                }
            }
            System.out.println(arr[i] + "--->" + ((v == -1) ? "No Min" : v));
        }
    }
}
