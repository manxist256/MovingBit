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
public class SearchAnElementInSortedAndRotatedArray {
    
    private static int getTransitionPoint(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) { //transition point lies in this sub_array
            if ((high - low) + 1 <= 3) {
                for (int k = low; k < high; k++) {
                    if (arr[k] > arr[k + 1]) {
                        return k + 1;
                    }
                }
            } else {
                int mid = (low + high) / 2;
                if (arr[low] < arr[mid] && arr[mid + 1] < arr[high]) {
                    mid += 1;
                }
                int la = getTransitionPoint(arr, low, mid);
                int ra = getTransitionPoint(arr, mid + 1, high);
                return la == -1 ? ra : la;
            }
        }
        return -1;
    }
    
    private static boolean search(int[] arr, int low, int high, int X) {
        if (low == high && arr[low] == X) return true;
        if (X >= arr[low] && X <= arr[high]) { // X lies in low -> high range
            int mid = (low + high) / 2;
            boolean ls = search(arr, low, mid, X);
            boolean rs = search(arr, mid + 1, high, X);
            return (ls || rs);
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int X = sc.nextInt();
        int tp = getTransitionPoint(arr, 0, arr.length - 1);
        //System.out.println(tp);
        if (X >= arr[0] && X <= arr[tp - 1]) {
            System.out.println(search(arr, 0, tp, X));
        } else if (X >= arr[tp] && X <= arr[arr.length - 1]) {
            System.out.println(search(arr, tp, arr.length - 1, X));
        } else {
            System.out.println(false);
        }
    }
}
