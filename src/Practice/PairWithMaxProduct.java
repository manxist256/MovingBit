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
public class PairWithMaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int fm = -1, sm = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= fm) {
                sm = fm;
                fm = arr[i];
            } else if (sm <= arr[i]) {
                sm = arr[i];
            }
        }
        System.out.println(fm + " " + sm);
        System.out.println(fm * sm);
    }
}
