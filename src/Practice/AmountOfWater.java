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
public class AmountOfWater {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                int[] lsm = new int[N], rsm = new int[N];
                int m = 0;
                for (int i = 0; i < N; i++) {
                        if (m < arr[i]) {
                                m = arr[i];
                        }
                        lsm[i]= m;
                }
                m = 0;
                for (int i = N - 1; i >= 0; i--) {
                        if (m < arr[i]) {
                                m = arr[i];
                        }
                        rsm[i]= m;
                }
                int aow = 0;
                for (int i = 0; i < N; i++) {
                        aow += ((int)Math.min(lsm[i], rsm[i]) - arr[i]);
                }
                System.out.println(aow);
        }
}
