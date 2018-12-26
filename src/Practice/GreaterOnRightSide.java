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
public class GreaterOnRightSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int b = arr[arr.length - 1];
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > b) {
                b = arr[i];
            }
            res[i] = b > arr[i] ? b : -1;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
