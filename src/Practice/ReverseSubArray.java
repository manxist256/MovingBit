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
public class ReverseSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int S = sc.nextInt() - 1, E = sc.nextInt() - 1;
        while (S < E) {
            int temp = array[S];
            array[S] = array[E];
            array[E] = temp;
            S++; E--;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
