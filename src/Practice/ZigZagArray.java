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
public class ZigZagArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int flag = 0;
        for (int i = 0; i < n - 1; i++) {
            if (flag == 0) {
                if (!(arr[i] < arr[i + 1])) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            } else {
                if (!(arr[i] > arr[i + 1])) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
            flag = flag == 0 ? 1 : 0;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
