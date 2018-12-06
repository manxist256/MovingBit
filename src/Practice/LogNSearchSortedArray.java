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
public class LogNSearchSortedArray {
    
        private static void search(int[] arr, int sdata) {
                search(arr, sdata, 0, arr.length - 1);
        }
        
        private static void search(int[] arr, int sdata, int l, int h) {
                int mid = (l + h) / 2;
                if (l == h && h == mid) {
                        if (sdata == arr[mid]) {
                                System.out.println("found " + sdata);
                        } else {
                                System.out.println("not found " + sdata);
                        }
                        return;
                }
                if (sdata <= arr[mid]) {
                        search(arr, sdata, l, mid);
                } else {
                        search(arr, sdata, mid + 1, h);
                }
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                        arr[i] = sc.nextInt();
                }
                int sdata = sc.nextInt();
                search(arr, sdata);
        }
}
