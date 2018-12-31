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
public class TypeOfArrayAndMaxElement {
    
    private static void findAscendingCategory(int[] arr) {
        boolean bitonic = false; int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                max = arr[i];
                bitonic = true;
                break;
            }
        }
        if (!bitonic) {
            System.out.println("Ascending : " + arr[arr.length - 1]);
        } else {
            System.out.println("Ascending Sorted : " + max);
        }
    }
    
    private static void findDescendingCategory(int[] arr) {
        boolean reversebitonic = false; int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                max = arr[i + 1];
                reversebitonic = true;
                break;
            }
        }
        if (!reversebitonic) {
            System.out.println("Descending : " + arr[0]);
        } else {
            System.out.println("Descending Sorted : " + max);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr[0] < arr[1]) {
            findAscendingCategory(arr);
        } else {
            findDescendingCategory(arr);
        }
    }
}
