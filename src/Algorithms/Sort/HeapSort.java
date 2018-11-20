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
public class HeapSort {
    
        private static final int HEAP_CAP = (int) 10e5;
        private static final int[] HEAP = new int[HEAP_CAP];
        private static int max;

        private static int getParent(int i) {
                return (i-1) / 2;
        }
        
        private static int getLeftChild(int i) {
                return 2 * i + 1;
        }
        
        private static int getRightChild(int i) {
                return 2 * i + 2;
        }
        
        private static boolean compare(int n1, int n2) {
            return n1 > n2;
        }
        
        private static void heapifyUp(int a) {
                HEAP[max] = a; max++;
                int child = max - 1;
                while (child > 0) {
                        int parent = getParent(child);
                        boolean c = compare(HEAP[child], HEAP[parent]);
                        if (!c) {
                                int temp = HEAP[child];
                                HEAP[child] = HEAP[parent];
                                HEAP[parent] = temp;
                                child = parent;
                                continue;
                        }
                        break;
                }
        }
        
        private static int compareChilds(int c1, int c2) {
                return HEAP[c1] > HEAP[c2] ? c2 : c1;
        }
        
        private static void heapifyDown() {
                HEAP[0] = HEAP[--max];
                HEAP[max] = 0;
                int parent = 0;
                while (parent <= max) {
                        int c1 = getLeftChild(parent);
                        int c2 = getRightChild(parent);
                        int smallerChild = compareChilds(c1, c2);
                        if (!compare(HEAP[smallerChild], HEAP[parent])) {
                                int temp = HEAP[parent];
                                HEAP[parent] = HEAP[smallerChild];
                                HEAP[smallerChild] = temp;
                                parent = smallerChild;
                                continue;
                        } 
                        break;
                }
                printResult();
        }

        private static void minHeapSort(int[] arr) {
                for (int i = 0; i < arr.length; i++) {
                        heapifyUp(arr[i]);
                }
        }

        private static void printResult() {
                for (int i = 0; i < max; i++) {
                        System.out.print(HEAP[i]+" ");
                }
                System.out.println();
        }

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int[] arr = new int[sc.nextInt()];
                for (int i = 0; i < arr.length; i++) {
                        arr[i] = sc.nextInt();
                }
                minHeapSort(arr);

                printResult();
                
                int N = sc.nextInt();
                
                while (N-- > 0) {
                        heapifyDown();
                }
        }
}
