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
public class RotateArrayByN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] array = new int[l];
        for (int i = 0; i < l; i++) {
            array[i] = sc.nextInt();
        }
        int N = sc.nextInt() % l;
        for (int i = 0; i < N; i++) {
            for (int j = array.length - 1; j > 0; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        for (int i = 0; i < l; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
