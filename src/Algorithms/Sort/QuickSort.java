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
public class QuickSort {
    
    private static void quickSort(int[] arr, int low, int high) {
            if (low >= high) {
                    return;
            }
            
            int pivot = arr[high];
            int i = low;
            
            for (int j = low; j < high; j++) {
                    if (arr[j] < pivot && i != j) {
                            int t = arr[j];
                            arr[j] = arr[i];
                            arr[i++] = t;
                    } else if (arr[j] < pivot && i == j) {
                            i++;
                    }
            }
            int t = arr[i]; // following 3 lines are logic to move pivot to it's current position.
            arr[i] = arr[high];
            arr[high] = t;
            
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
    }
    
    private static void printResult(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
            }
            System.out.println("");
    }
    
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), arr[] = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                
                quickSort(arr, 0, arr.length-1);
                printResult(arr);
        }
}
