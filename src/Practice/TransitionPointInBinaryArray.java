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

public class TransitionPointInBinaryArray {
    
    private static int binarysearch(int[] arr, int low, int high) {
        if (arr[low] == arr[high] && arr[high] == 0) {
            return Integer.MAX_VALUE;
        }
        if (arr[low] == 1) {
            return low;
        }
        int mid = (low + high) / 2;
        int lv = binarysearch(arr, low, mid);
        int rv = binarysearch(arr, mid + 1, high);
        return lv > rv ? rv : lv;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(binarysearch(arr, 0, arr.length - 1));
    }
}
