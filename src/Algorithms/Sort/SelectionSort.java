/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Sort;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class SelectionSort {
    
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[pos];
            arr[pos] = t;
        }
    }
    
    private static void printResult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        selectionSort(arr);
        printResult(arr);
        
    }
}
