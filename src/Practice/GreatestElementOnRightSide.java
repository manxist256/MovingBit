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
public class GreatestElementOnRightSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = -1;
        int[] result = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            result[i] = max;
            if (arr[i] > max) { max = arr[i]; }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
