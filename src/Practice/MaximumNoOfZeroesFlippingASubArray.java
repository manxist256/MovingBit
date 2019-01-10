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
// KADANE'S ALGORITHM
public class MaximumNoOfZeroesFlippingASubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) arr[i] = -1;
        }
        int c = 0, max = 0, k = 0, l = 0, sk = 0, sl = 0;
        for (int i = 0; i < N; i++) {
            c += arr[i];
            if (c <= 0) {
                k = i + 1;
                c = 0;
            }
            l = i;
            if (c > max) { 
                sk = k;
                sl = l;
                max = c;
            }
        }
        int zc = 0;
        for (int i = 0; i < N; i++) {
            if (i >= sk && i <= sl) {
                if (arr[i] == 1) zc++;
                else zc--;
            } else if (arr[i] == -1) {
                zc++;
            }
        }
        System.out.println(zc);
    }
}
