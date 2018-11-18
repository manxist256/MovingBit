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
public class MergeSort {
    
        private static void mergeSort(int[] arr, int i, int j) {
                if (i == j) return;
                int mid = (j + i) / 2;
                mergeSort(arr, i, mid);
                mergeSort(arr, mid + 1, j);
                // sort 2-sorted arrays
                int[] s1 = new int[(mid - i) + 1];
                int[] s2 = new int[j - mid];
                int ii = i, jj = mid + 1;
                for (int k = 0; k < s1.length; k++) {
                        s1[k] = arr[ii++];
                }
                for (int k = 0; k < s2.length; k++) {
                        s2[k] = arr[jj++];
                }
                int a1 = 0, a2 = 0, up = i;
                while (a1 < s1.length && a2 < s2.length) {
                        if (s1[a1] < s2[a2]) {
                                arr[up++] = s1[a1];
                                a1++;
                        } else if (s1[a1] > s2[a2]) {
                                arr[up++] = s2[a2];
                                a2++;
                        } else {
                                arr[up++] = s1[a1];
                                arr[up++] = s2[a2];
                                a1++; a2++;
                        }
                }
                while (a1 < s1.length) {
                    arr[up++] = s1[a1++];
                }
                while (a2 < s2.length) {
                    arr[up++] = s2[a2++];
                }
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

                mergeSort(arr, 0, arr.length-1);
                printResult(arr);
        }
}
