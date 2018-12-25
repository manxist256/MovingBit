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
public class SubArrayWithGnSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        outer : for (int i = 0; i < N; i++) {
            int s = 0;
            for (int j = i; j < N; j++) {
                s += arr[j];
                if (s == sum) {
                    System.out.println("sum found in range " + i +" to " + j);
                    break outer;
                }
            }
        }
    }
}
