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
public class XORofAllSubArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n % 2 == 0) { System.out.println(0); return; }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 != 0) {
                res ^= arr[i];
            }
        }
        System.out.println(res);
    }
}
