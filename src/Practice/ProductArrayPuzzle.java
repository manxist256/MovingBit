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
public class ProductArrayPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int tp = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            tp *= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(tp / arr[i] + " ");
        }
    }
}
