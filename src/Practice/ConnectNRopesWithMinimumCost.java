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
public class ConnectNRopesWithMinimumCost {
    
    static int MAX_CAPACITY = (int)10e5;
    static int[] heap = new int[MAX_CAPACITY];
    static int pos = 0;
    
    private static int getParent(int i) {
        return (i - 1) / 2;
    }
    
    private static void heapifyUp(int v) {
        heap[pos] = v;
        int p = pos;
        while (p != 0) {
            int parent = getParent(p);
            if (heap[parent] > heap[p]) {
                int temp = heap[p];
                heap[p] = heap[parent];
                heap[parent] = temp;
            } else {
                break;
            }
            p = parent;
        }
        pos += 1;
    }
    
    private static int getLeftChild(int i) {
        return 2 * i + 1;
    }
    
    private static int getRightChild(int i) {
        return 2 * i + 2;
    }
    
    private static int getSmallerChild(int left, int right) {
        if (left > pos && right > pos) { //both child not exists
            return -1;
        } else if (right > pos) { //left child exists
            return left;
        }
        return heap[left] > heap[right] ? right : left;
    }
    
    private static void heapifyDown() {
        heap[0] = heap[--pos];
        int parent = 0;
        while (parent <= pos) {
            int left = getLeftChild(parent);
            int right = getRightChild(parent);
            int smallerChild = getSmallerChild(left, right);
            if (smallerChild == -1 || heap[parent] <= heap[smallerChild]) { //no child exists
                break;
            }
            int temp = heap[smallerChild];
            heap[smallerChild] = heap[parent];
            heap[parent] = temp;
        }
    }
    
    private static void connectNRopes() {
        int cost = 0;
        while (pos > 1) {
            int f = heap[0];
            heapifyDown();
            int s = heap[0];
            heapifyDown();
            cost += (f + s);
            heapifyUp(f + s);
        }
        System.out.println(cost);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            heapifyUp(arr[i]);
        }
        connectNRopes();
    }
}
