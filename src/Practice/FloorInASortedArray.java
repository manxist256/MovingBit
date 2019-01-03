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
public class FloorInASortedArray {
    private static int binarysearch(int[] arr, int low, int high, int x) {
        if (arr[low] > x) {
            return Integer.MIN_VALUE;
        }
        if (arr[high] <= x) {
            return arr[high];
        }
        int mid = (low + high) / 2;
        int lv = binarysearch(arr, low, mid, x);
        int rv = binarysearch(arr, mid + 1, high, x);
        return lv > rv ? lv : rv;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(binarysearch(arr, 0, arr.length - 1, x));
    }
}
