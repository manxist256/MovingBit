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
public class SortAnArrayOf012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int zc = 0, oc = 0, tc = 0;
        for (int i = 0; i < N; i++) {
            switch(arr[i]) {
                case 0 : zc++; break;
                case 1 : oc++; break;
                case 2 : tc++; break;
            }
        }
        for (int i = 0; i < N; i++) {
            if (zc-- > 0) {
                arr[i] = 0;
            } else if (oc-- > 0) {
                arr[i] = 1;
            } else if (tc-- > 0) {
                arr[i] = 2;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
