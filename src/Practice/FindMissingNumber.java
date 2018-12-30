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
public class FindMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N - 1; i++) {
            int v = sc.nextInt();
            arr[v - 1] = v;
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
