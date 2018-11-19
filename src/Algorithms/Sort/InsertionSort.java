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
public class InsertionSort {
        private static void insertionSort(int[] arr) {
                for (int i = 0; i < arr.length; i++) {
                        int c = arr[i];
                        for (int j = i - 1; j >= 0; j--) {
                                if (c < arr[j]) {
                                        arr[j + 1] = arr[j];
                                        arr[j] = c;
                                } else {
                                        break;
                                }
                        }
                }
        }

        private static void printResult(int[] arr) {
                for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                }
                System.out.println();
        }

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), arr[] = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                insertionSort(arr);
                printResult(arr);
        }
}
